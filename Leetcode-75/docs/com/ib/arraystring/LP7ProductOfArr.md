# 238. Product of Array Except Self

**Difficulty**: Medium

## Problem Statement
Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`. The product of any prefix or suffix of `nums` is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation.

### Examples

**Example 1:**
- **Input**: `nums = [1,2,3,4]`
- **Output**: `[24,12,8,6]`

**Example 2:**
- **Input**: `nums = [-1,1,0,-3,3]`
- **Output**: `[0,0,9,0,0]`

### Constraints
- 2 <= nums.length <= 105
- -30 <= nums[i] <= 30
- The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

### Follow-up
Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

## Solution

```java

package com.ib.arraystring;

public class LP7ProductOfArr {

	public static void main(String[] args) {

		new Solution7().productExceptSelf3(new int[] { 10,2,3,4,5 });
	}

}

class Solution7 {
	public int[] productExceptSelf1(int[] nums) {

		int[] answer = new int[nums.length];
		int mult = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (j == i)
					continue;
				mult = mult * nums[j];
			}
			answer[i] = mult;
			mult = 1;
		}
		return answer;
	}

	public int[] productExceptSelf2(int[] nums) {

		int[] answer = new int[nums.length];
		int mult = 1;
		for (int i : nums) {
			mult = mult * i;
		}
		for (int i = 0; i < nums.length; i++) {
			answer[i] = mult / nums[i];
		}
		return answer;
	}
	
	public int[] productExceptSelf3(int[] nums) {

		int[] prefixes = new int[nums.length];
		int[] suffixes = new int[nums.length];
		int[] answer = new int[nums.length];
		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			
			prefixes[i] = prefix;
			System.out.println(prefixes[i]);
			System.out.println("pre"+prefix);
			
			prefix = prefix * nums[i];
			System.out.println("after pre"+prefix);
		}
		
		int suffix = 1;
		for (int i = nums.length-1; i >=0; i--) {
			
			suffixes[i] = suffix;
			System.out.println(suffixes[i]);
			System.out.println("pre"+suffix);
			suffix = suffix * nums[i];
			System.out.println("after "+suffix);
		}
		
		for (int i = 0; i < nums.length; i++) {
			answer[i] =prefixes[i]* suffixes[i];
		}
		
		for (int i : answer) {
			System.out.print(i+",");
		}
		return answer;
	}

	public int[] productExceptSelf4(int[] nums) {
		int n = nums.length, mult = 1;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = mult;
			mult *= nums[i];
		}
		mult = 1;
		for (int j = n - 1; j >= 0; j--) {
			ans[j] *= mult;
			mult *= nums[j];
		}
		return ans;
	}
}