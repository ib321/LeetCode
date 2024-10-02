# 1679. Max Number of K-Sum Pairs

**Difficulty**: Medium

## Problem Statement

You are given an integer array `nums` and an integer `k`.

In one operation, you can pick two numbers from the array whose sum equals `k` and remove them from the array.

Return the maximum number of operations you can perform on the array.

### Examples

## Example 1:

**Input:** `nums = [1,2,3,4]`, `k = 5`

**Output:** `2`

**Explanation:** Starting with `nums = [1,2,3,4]`:
- Remove numbers 1 and 4, then `nums = [2,3]`
- Remove numbers 2 and 3, then `nums = []`

There are no more pairs that sum up to 5, hence a total of 2 operations.

## Example 2:

**Input:** `nums = [3,1,3,4,3]`, `k = 6`

**Output:** `1`

**Explanation:** Starting with `nums = [3,1,3,4,3]`:
- Remove the first two 3's, then `nums = [1,4,3]`

There are no more pairs that sum up to 6, hence a total of 1 operation.

## Constraints:

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= k <= 10^9`

### Hint 1
The abstract problem asks to count the number of disjoint pairs with a given sum k.

### Hint 2
For each possible value x, it can be paired up with k - x.

### Hint 3
The number of such pairs equals to min(count(x), count(k-x)), unless that x = k / 2, where the number of such pairs will be floor(count(x) / 2).

[LeetCode Problem URL](https://leetcode.com/problems/max-number-of-k-sum-pairs/description/?envType=study-plan-v2&envId=leetcode-75)

## Solution

```java

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
