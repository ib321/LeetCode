package com.ib.p03_slidingwindow;

public class LP16_MaxConsecutiveOne {

	public static void main(String[] args) {
		System.out.println(new Solution16().longestOnes(new int[] {1,1,1,0,0,1,1,1,1,0}, 2));
	}
}


class Solution16 {
	/**
	 * So here the approach is solved using the sliding window
	 * 1. we started our windows pointer left and right both at index = 0 mean with 0 window size
	 * 2. zeroCount is just here to help count the zeroes
	 * 3. Goal is to find the largest size window 
	 *    (just one insurance that max length window have zero < maxFlips)
	 * 4. we keep increasing the right++ so we get to the max window
	 * 5. but once that window hits the maxFlips allowed zeroes
	 * 		a. we do two thing: one now we slide this biggest window how by moving both right++ and left++
	 * 		b. and if there are any zero which get excluded in left side we zeroCount--
	 * 			 & zeroCount++ is also going on if we find new zeroes
	 * 6. at last we return the right - left. cause it carried the max window size.
	 * @param nums
	 * @param maxFlips
	 * @return
	 */
	public int longestOnes(int[] nums, int maxFlips) {
		int left = 0, right = 0, zeroCount = 0;

		while (right < nums.length) {
			if (nums[right] == 0) {
				zeroCount++;
			}
			if (zeroCount > maxFlips) {
				if (nums[left] == 0) {
					zeroCount--;
				}
				left++;
			}
			
			right++;
		}

		return right - left;
	}
}
