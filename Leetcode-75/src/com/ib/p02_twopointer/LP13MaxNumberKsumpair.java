package com.ib.p02_twopointer;

import java.util.Arrays;

public class LP13MaxNumberKsumpair {

	public static void main(String[] args) {
		System.out.println(new Solution13().maxOperations(new int[] { 1, 2, 3, 4 }, 5));
		System.out.println(new Solution13().maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));

	}
}

class Solution13 {

	/*-Two pointer approach
	 * 	Trick here is to sort the array then use two pointer
	 * 	so we sort the array we start two pointer left(0) n right(len-1);
	 * 	loop until left < right(i.e until two pointers meet at middle)
	 * 	inside loop how to adjust the pointers:
	 * 	add rigth and left if they sums up to k then right-- left++ and as 1 oprn happened so opr++
	 * 	if addition is greater then k mean we need lower element right-- only keep left at same
	 * 	if add is lower then k mean we need higher elem left++ keep right at same
	 * 	return the opr count
	 * 
	 * 
	 */
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
