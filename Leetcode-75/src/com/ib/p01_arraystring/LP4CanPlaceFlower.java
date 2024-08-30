package com.ib.p01_arraystring;

public class LP4CanPlaceFlower {

	public static void main(String[] args) {
		int[] n = { 0, 0, 0, 0, 0 };

		System.out.println(new Solution4().canPlaceFlowers(n, 2));

	}

}

class Solution4 {
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
