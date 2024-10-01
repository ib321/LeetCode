package com.ib.p01_arraystring;

import java.util.ArrayList;
import java.util.List;

public class LP3GreatestNoCandies {

	public static void main(String[] args) {
		int[] candiesarr = { 2, 3, 5, 1, 3 };
		new Solution3().kidsWithCandies(candiesarr, 3);

	}

}

class Solution3 {
	/**
	 * Approach:
	 * 		Find Max candies that candies array has.
	 * 		now loop the candies array
	 * 			add extra candy with each element & compare with max
	 * 			if greater or equal to max add true in result array else false
	 * return result boolean array.
	 * 
	 * @param candies
	 * @param extraCandies
	 * @return Return a boolean array result of length n,
	 *  where result[i] is true if, after giving the ith kid all the extraCandies,
	 *   they will have the greatest number of candies among all the kids, or false otherwise.
	 * Input: candies = [2,3,5,1,3], extraCandies = 3 -- Output: [true,true,true,false,true]
	 */
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> result = new ArrayList<Boolean>();
		int max = candies[0];
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] > max)
				max = candies[i];
		}

		for (int i = 0; i < candies.length; i++) {
			if ((candies[i] + extraCandies) >= max)
				result.add(true);
			else
				result.add(false);
		}
		System.out.println(result.toString());
		return result;
	}
}