package com.ib.p03_slidingwindow;

public class LP17_LongestSubArray {

	public static void main(String[] args) {
		System.out.println(new Solution17().longestSubarray(new int[] { 0,1,1,1,0,1,1,0,1 }));
	}
}

class Solution17 {
	/**
	 * First we will find the max window with only containg 1 zero.
	 * To Find that we will use same Approach as previous question(LP16)
	 * So it's like put maxFlip = 0;
	 * @param nums
	 * @return After deleting one element from array. 
	 * size of the longest non-empty sub array containing only 1's in the resulting array. 
	 * 0 if there is no such sub array.
	 */
	public int longestSubarray(int[] nums) {
		int left = 0, right = 0, countZero = 0;
		while (right < nums.length) {
			if (nums[right] == 0) {
				countZero++;
			}

			if (countZero > 1) {
				if (nums[left] == 0)
					countZero--;
				left++;
			}
			right++;
		}
		// Using this output variable so when there is no such array it return zero instead of -1;
		int output = 0;
		output = Math.max(right - left-1, output);
		return output;
	}
}