# 1004. Max Consecutive Ones III

**Difficulty**: Medium

## Problem Statement
Given a binary array `nums` and an integer `k`, return the maximum number of consecutive 1's in the array if you can flip at most `k` 0's.

### Examples

**Example 1:**
- **Input**: `nums = [1,1,1,0,0,0,1,1,1,1,0]`, `k = 2`
- **Output**: `6`
- **Explanation**: `[1,1,1,0,0,1,1,1,1,1,1]` (Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.)

**Example 2:**
- **Input**: `nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]`, `k = 3`
- **Output**: `10`
- **Explanation**: `[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]` (Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.)

### Constraints
- 1 <= nums.length <= 105
- nums[i] is either 0 or 1.
- 0 <= k <= nums.length

### Topics
- Array
- Binary Search
- Sliding Window
- Prefix Sum

### Hints
1. One thing's for sure, we will only flip a zero if it extends an existing window of 1s. Otherwise, there's no point in doing it, right? Think Sliding Window!
2. Since we know this problem can be solved using the sliding window construct, we might as well focus in that direction for hints. Basically, in a given window, we can never have > K zeros, right?
3. We don't have a fixed size window in this case. The window size can grow and shrink depending upon the number of zeros we have (we don't actually have to flip the zeros here!).
4. The way to shrink or expand a window would be based on the number of zeros that can still be flipped and so on.

LeetCode Problem URL

## Solution

```java

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
