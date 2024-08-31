# 724. Find Pivot Index

**Difficulty**: Easy

## Problem Statement
Given an array of integers `nums`, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

### Examples

**Example 1:**
- **Input**: `nums = [1,7,3,6,5,6]`
- **Output**: `3`
- **Explanation**: The pivot index is 3. Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11. Right sum = nums[4] + nums[5] = 5 + 6 = 11.

**Example 2:**
- **Input**: `nums = [1,2,3]`
- **Output**: `-1`
- **Explanation**: There is no index that satisfies the conditions in the problem statement.

**Example 3:**
- **Input**: `nums = [2,1,-1]`
- **Output**: `0`
- **Explanation**: The pivot index is 0. Left sum = 0 (no elements to the left of index 0). Right sum = nums[1] + nums[2] = 1 + (-1) = 0.

### Constraints
- 1 <= nums.length <= 10^4
- -1000 <= nums[i] <= 1000

### Topics
- Array
- Prefix Sum

### Hints
1. Create an array `sumLeft` where `sumLeft[i]` is the sum of all the numbers to the left of index `i`.
2. Create an array `sumRight` where `sumRight[i]` is the sum of all the numbers to the right of index `i`.
3. For each index `i`, check if `sumLeft[i]` equals `sumRight[i]`. If so, return `i`. If no such `i` is found, return `-1`.

[LeetCode Problem URL](https://leetcode.com/problems/find-the-middle-index-in-array/)

## Solution

```java

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