package com.ib.p01_arraystring;

import java.util.Arrays;

public class LP8IncresingTripletSubSeq {

	public static void main(String[] args) {
		new Solution8().increasingTriplet2(new int[] { 20, 100, 10, 12, 5, 13, 14, 12 });
	}

}

class Solution8 {

	// In this solution there are some concern raised as for this test case it is
	// false: 20, 100, 10, 12, 5, 13
	// This should be true as 10<12<13 where 2<3<5 so constraint are being followed
	// here.
	public boolean increasingTriplet(int[] nums) {

		if (nums.length < 3)
			return false;

		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;

		for (int i : nums) {
			if (i <= smallest)
				smallest = i;
			else if (i <= secondSmallest)
				secondSmallest = i;
			else {
				System.out.println(smallest + " " + secondSmallest + " " + " " + i);
				return true;
			}
		}
		System.out.println(smallest + " " + secondSmallest);
		return false;
	}

	/*-
	 * Approach: 
	 * 	This method uses two auxiliary arrays, minArr and maxArr,
	 *  to store the minimum values up to the current index and the maximum values from the current index to the end
	 *  It then checks if there exists an element that is greater than all previous minimums and less than all subsequent maximums.
	 * 	if yes then we proved that there exists a triple indices
	 *  
	 * @param nums
	 * @return
	 */
	public boolean increasingTriplet2(int[] nums) {

		if (nums == null || nums.length < 3) {
			return false;
		}
		int[] minArr = new int[nums.length];
		int[] maxArr = new int[nums.length];

		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			minVal = Math.min(minVal, nums[i]);
			minArr[i] = minVal;
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			maxVal = Math.max(maxVal, nums[i]);
			maxArr[i] = maxVal;
		}

		boolean result = false;
		for (int i = 1; i < nums.length - 1; i++) {
			if (minArr[i - 1] < nums[i] && nums[i] < maxArr[i + 1]) {
				System.out.println(minArr[i - 1] + " " + nums[i] + " " + maxArr[i + 1]);
				result = true;
				break;
			}
		}
//		System.out.println(result);
//		System.out.println(Arrays.toString(minArr));
		System.out.println(Arrays.toString(maxArr));
		return result;
	}
}
