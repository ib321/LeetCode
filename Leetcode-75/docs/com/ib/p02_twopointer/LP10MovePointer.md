# 283. Move Zeroes

**Difficulty**: Easy

## Problem Statement
Given an integer array `nums`, move all 0's to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

### Examples

**Example 1:**
- **Input**: `nums = [0,1,0,3,12]`
- **Output**: `[1,3,12,0,0]`

**Example 2:**
- **Input**: `nums = [0]`
- **Output**: `[0]`

### Constraints
- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

### Follow-up
Could you minimize the total number of operations done?

[LeetCode Problem URL](https://leetcode.com/problems/move-zeroes/)
### Hint 1
In-place means we should not be allocating any space for extra array. But we are allowed to modify the existing array. However, as a first step, try coming up with a solution that makes use of additional space. For this problem as well, first apply the idea discussed using an additional array and the in-place solution will pop up eventually.

###Hint 2
A two-pointer approach could be helpful here. The idea would be to have one pointer for iterating the array and another pointer that just works on the non-zero elements of the array.

## Solution

```java

package com.ib.p02_twopointer;

import java.util.Arrays;

public class LP10MovePointer {

	public static void main(String[] args) {
		new Solution10().moveZeroes3(new int[] { 0, 1, 0, 3, 12 });

	}

}

class Solution10 {

	/*-Tip check out 2nd method cute isn't it...
	 *Approach:
	 * 	Aim is to put all the zero of given array to last
	 * 
	 *Two  Array Approach: 
	 *	initialize another array with same length;
	 *	loop input array use whenever non zero element put into new array into consecutive order
	 *	use a index pointer to maintain the order
	 *	now loop again this time just replace all the element with zero that are non zero.
	 */
	public void moveZeroes3(int[] nums) {
		int[] arr2 = new int[nums.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				arr2[index++] = nums[i];
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (!(arr2[i] != 0))
				arr2[i] = 0;
		}

		System.out.println(Arrays.toString(arr2));
	}

	/*-
	 * Approach:
	 * 	Aim is to put all the zero of given array to last
	 * 	Optimization : 
	 * 		we can use same array for the above operartion
	 * 		we can start second loop from index pointer to last length
	 * @param nums : integer array 
	 */
	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[index++] = nums[i];
		}

		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
		// System.out.println(Arrays.toString(nums));
	}

	/*-
	 * Ignnore this if you still want it ok go ahead.. :)
	 */
	public void moveZeroes2(int[] nums) {
		int index = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				nums[index++] = nums[i];
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (count == 0)
				break;
			nums[i] = 0;
			count--;
		}
		// System.out.println(Arrays.toString(nums));
	}

}