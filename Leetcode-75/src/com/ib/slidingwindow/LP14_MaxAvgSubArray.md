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

package com.ib.slidingwindow;


public class LP14_MaxAvgSubArray {

	public static void main(String[] args) {
		System.out.println(new Solution14().findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));
	}
}

class Solution14 {
    public double findMaxAverage(int[] nums, int k) {
    	int currSum = 0;
		for (int i = 0; i < k; i++) {
			currSum += nums[i];
		}
		int maxSum = currSum;
    	for (int i = k; i < nums.length ; i++) {
    		currSum = currSum + nums[i] - nums[i-k];
    		if(currSum>maxSum)
    			maxSum = currSum;
		}
    	return (double)maxSum/k;
    }
}
