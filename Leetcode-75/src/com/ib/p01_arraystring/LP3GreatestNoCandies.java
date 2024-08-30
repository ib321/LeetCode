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