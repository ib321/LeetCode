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

### Hint 1:
Think how you can efficiently utilize prefix and suffix products to calculate the product of all elements except self for each index. Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?

### Hint 2:
Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?

## Solution

```java

package com.ib.p01_arraystring;

public class LP7ProductOfArr {

	public static void main(String[] args) {

		new Solution7().productExceptSelf3(new int[] { 10, 2, 3, 4, 5 });
	}

}

class Solution7 {
	/**
	 * Approach: Brute force:
	 * 	loop the input array : 
	 * 	now to multiply loop another array when loops at same index continue;
	 * 	store multiply into array and done
	 * 
	 * @param nums : input array
	 * @return : Array whose elements are product of array element exxept self.
	 */
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

	/**
	 * Approach: Divide by Self Approach:
	 * 	Find the multiplication of all the array element
	 * 	then loop on array and for each element you divide the total multi with curr element
	 * 	store that this will be the multi except self done
	 */
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

	/**
	 * Approach: prefix and suffix products :
	 * 	create two arrays prefix and suffix: 
	 * 	Prefix : array which stores product of element before i.
	 * 		[2,3,4,5,6] in this array at i = 2 ; will be 1*2*3 = 6;
	 * 		to do this just multiply last multiple with the current element
	 * 		store this multi into prefix array on next i.
	 * 	Suffix : it stores product of element after i.
	 * 		[2,3,4,5,6] in this array at i = 2 ; will be 1*5*6 = 30;
	 * 	
	 * Now Main Approach:
	 * 	loop the array: for i multiply prefix and suffix.
	 * 	[2,3,4,5,6] for i = 2; calcul: product expect 4 at i=2 = 2*3*5*6 = 180
	 * 	multiply the prefix suffix for i = 2; prefix 6 * suffix 30 = 180
	 */
	public int[] productExceptSelf3(int[] nums) {
		int[] prefixes = new int[nums.length];
		int[] suffixes = new int[nums.length];
		int[] answer = new int[nums.length];
		int prefix = 1;
		int suffix = 1;

		for (int i = 0; i < nums.length; i++) {
			prefixes[i] = prefix;
			// System.out.println("pre" + prefix);
			prefix = prefix * nums[i];
			// System.out.println("after pre" + prefix);
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			suffixes[i] = suffix;
			// System.out.println("pre" + suffix);
			suffix = suffix * nums[i];
			// System.out.println("after " + suffix);
		}
		for (int i = 0; i < nums.length; i++) {
			answer[i] = prefixes[i] * suffixes[i];
		}
		return answer;
	}

	/**
	 * Approach: Prefix Suffix product without using prefix & suffix array:
	 * 	Here basically we removed the prefix and suffix array
	 * 	 and used only one ans array to do the same.
	 * Main Approach: [2,3,4,5,6]
	 * 	Prefix calculatation is same: so now our ans array will have [1,2,6,24,120]
	 * 	In Suffix calculation we do the trick:: 
	 * 	when we store the suffix in ans what we do that
	 * 	we multiply that suffix product with current element which was calculated prefix
	 * 	for j = 2; mult was = 30 now in final storing ans[j] = 6 so ans[j] = 6 * 30;
	 * 
	 */
	public int[] productExceptSelf4(int[] nums) {
		int n = nums.length, mult = 1;
		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = mult;
			mult = mult * nums[i];
		}
		mult = 1;
		for (int j = n - 1; j >= 0; j--) {
			ans[j] = ans[j] * mult;
			mult = mult * nums[j];
		}
		return ans;
	}
}