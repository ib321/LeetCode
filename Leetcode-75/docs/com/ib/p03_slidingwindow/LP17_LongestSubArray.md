# 1493. Longest Subarray of 1's After Deleting One Element

**Difficulty**: Medium

## Problem Statement
Given a binary array `nums`, you should delete one element from it. Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

### Examples

**Example 1:**
- **Input**: `nums = [1,1,0,1]`
- **Output**: `3`
- **Explanation**: After deleting the number in position 2, `[1,1,1]` contains 3 numbers with value of 1's.

**Example 2:**
- **Input**: `nums = [0,1,1,1,0,1,1,0,1]`
- **Output**: `5`
- **Explanation**: After deleting the number in position 4, `[0,1,1,1,1,1,0,1]` longest subarray with value of 1's is `[1,1,1,1,1]`.

**Example 3:**
- **Input**: `nums = [1,1,1]`
- **Output**: `2`
- **Explanation**: You must delete one element.

### Constraints
- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.

### Topics
- Array
- Dynamic Programming
- Sliding Window

### Hints
1. Maintain a sliding window where there is at most one zero on it.

[LeetCode Problem URL](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)

## Solution

```java

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