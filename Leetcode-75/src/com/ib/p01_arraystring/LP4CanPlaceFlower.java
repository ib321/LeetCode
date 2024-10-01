package com.ib.p01_arraystring;

public class LP4CanPlaceFlower {

	public static void main(String[] args) {
		int[] n = { 0, 0, 0, 0, 0 };

		System.out.println(new Solution4().canPlaceFlowers(n, 2));

	}

}

class Solution4 {
	/**
	 * Approach:
	 * 	for loop i 0 to < length of flower pot array
	 * 	Now simply check for each i is this place empty :: flowerbed[i] == 0
	 * 	If yes "plant the flower" no... wait wait
	 * 	then check if previous pot is empty flowerbed[i-1] == 0
	 * 	and check if next pot is empty 		flowerbed[i+1] == 0
	 * 	if both prev && next is empty plot flower flowerbed[i] = 1;
	 *	increase maxFlowerPlant count and update
	 *
	 *one edge case: 
	 *	For the first plot, only check if the next plot is empty.
	 *	in prev check: if i = 0; flowerbed[i-1] fat jayega if i == 0 above flowerbed[i] == 0
	 *	so that mean previous is empty || condtition lga so on i == 0;
	 *two edge case:
	 *	For the last plot, only check if the previous plot is empty.
	 *	in next check if i = max at < length then flowerbed[i + 1] fat jayega
	 *	as uper already checked h ki flowerbed[i] == 0 that mean if i == max then next is empty
	 * 
	 * flowers cannot be planted in adjacent plots.
	 * @param flowerbed array 
	 * @param n
	 * @return return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
	 * Input: flowerbed = [1,0,0,0,1], n = 1 -- Output: true
	 * Input: flowerbed = [1,0,0,0,1], n = 2 -- Output: false
	 */
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int maxflowercanbeplated = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				boolean prevEmpty = (i == 0) || flowerbed[i - 1] == 0;
				boolean nextEmpty = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;
				if (prevEmpty && nextEmpty) {
					++maxflowercanbeplated;
					flowerbed[i] = 1;
				}
			}
		}

		return n <= maxflowercanbeplated;
	}
}
