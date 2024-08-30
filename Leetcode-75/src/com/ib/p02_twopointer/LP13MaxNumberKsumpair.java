package com.ib.p02_twopointer;

import java.util.Arrays;

public class LP13MaxNumberKsumpair {

	public static void main(String[] args) {
		System.out.println(new Solution13().maxOperations(new int[] { 1, 2, 3, 4 }, 5));

	}
}

class Solution13 {
	public int maxOperations(int[] nums, int k) {
		int left = 0;
		int right = nums.length - 1;
		int oprCount = 0;
		Arrays.sort(nums);
		// System.out.println(Arrays.toString(nums));
		while (left < right) {
			if (nums[left] + nums[right] == k) {
				oprCount++;
				left++;
				right--;
			} else if (nums[left] + nums[right] > k)
				right--;
			else
				left++;
		}
		return oprCount;
	}
}
