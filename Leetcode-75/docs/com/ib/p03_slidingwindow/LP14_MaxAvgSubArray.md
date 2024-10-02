# 643. Maximum Average Subarray I

**Difficulty**: Easy

## Problem Statement
You are given an integer array `nums` consisting of `n` elements, and an integer `k`. Find a contiguous subarray whose length is equal to `k` that has the maximum average value and return this value. Any answer with a calculation error less than 10^-5 will be accepted.

### Examples

**Example 1:**
- **Input**: `nums = [1,12,-5,-6,50,3]`, `k = 4`
- **Output**: `12.75000`
- **Explanation**: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

**Example 2:**
- **Input**: `nums = [5]`, `k = 1`
- **Output**: `5.00000`

### Constraints
- `n == nums.length`
- `1 <= k <= n <= 105`
- `-104 <= nums[i] <= 104`

[LeetCode Problem URL](https://leetcode.com/problems/maximum-average-subarray-i/)

## Solution

```java

package com.ib.p03_slidingwindow;

public class LP14_MaxAvgSubArray {

	public static void main(String[] args) {
		System.out.println(new Solution14().findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
	}
}

class Solution14 {

	/**
	 * This method finds the maximum average of any subarray of length k using the sliding window approach.
	 * 1. Initialize the current sum with the sum of the first k elements.
	 * 2. Set the maximum sum to the current sum initially.
	 * 3. Slide the window across the array:
	 *    a. For each new element added to the window, subtract the element that is left out of the window.
	 *    b. Update the current sum and check if it is greater than the maximum sum.
	 * 4. Continue this process until the end of the array.
	 * 5. Return the maximum sum divided by k to get the maximum average.
	 * 
	 * @param nums the array of integers
	 * @param k the number of elements in each subarray
	 * @return the maximum average of any subarray of length k
	 */
	 
	/*-Sliding windows: { 1, 12, -5, -6, 50, 3 }
	 * Approach: is to find the max sum:
	 * 	focus on window of k = 4; (1, 12, -5, -6) first calc sum = 2 
	 * 	max = currSum; will update it with each window
	 * 	Now next loop is essentially sliding window
	 * 	next window is (12, -5, -6, 50) added 50 removed 1
	 * 	+ nums[i] - nums[i-k] into current sum then update if max
	 * return maxsum/k into double
	 * 
	 * @param nums : avg whose max element avg is to be calc
	 * @param k : how many elements avg
	 * @return : max avg of given array with given no of element.
	 */
	public double findMaxAverage(int[] nums, int k) {
		int currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += nums[i];
		}
		int maxSum = currSum;
		for (int i = k; i < nums.length; i++) {
			currSum = currSum + nums[i] - nums[i - k];
			if (currSum > maxSum)
				maxSum = currSum;
		}
		return (double) maxSum / k;
	}
}
