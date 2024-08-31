package com.ib.p04_prefixsum;

import java.util.Arrays;

public class LP19_FindPivotIndex {

	public static void main(String[] args) {
		System.out.println(new Solution19().pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 })); //3
		System.out.println(new Solution19().pivotIndex(new int[] { -1, -1, 0, 0, -1, -1 })); //2

	}
}

class Solution19 {
	
	/**
	 * Going with this approach:
	 * Hint 1: 
	 * Create an array sumLeft where sumLeft[i] is the sum of all the numbers to the left of index i.
	 * Hint 2
	 * Create an array sumRight where sumRight[i] is the sum of all the numbers to the right of index i.
	 * Hint 3
	 * For each index i, check if sumLeft[i] equals sumRight[i]. If so, return i. If no such i is found, return -1.
	 * One More Hint: Need to return the left most pivot index. so break loop As you find the equal index.
	 * @param nums
	 * @return
	 */
	public int pivotIndex(int[] nums) {
		int length = nums.length;

		int[] sumleft = new int[length];
		int leftSum = 0;
		for (int i = 0; i < length; i++) {
			sumleft[i] = leftSum;
			leftSum = leftSum + nums[i];
		}
		System.out.println(Arrays.toString(sumleft));

		int[] sumRight = new int[length];
		int rightSum = 0;
		for (int j = length - 1; j >= 0; j--) {
			sumRight[j] = rightSum;
			rightSum = rightSum + nums[j];
		}
		System.out.println(Arrays.toString(sumRight));

		int outputIndex = -1;
		for (int i = 0; i < length; i++) {
			if (sumleft[i] == sumRight[i]) {
				outputIndex = i;
				break;
			}

		}
		return outputIndex;
	}
}