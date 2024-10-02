# 392. Is Subsequence

**Difficulty**: Easy

## Problem Statement
Given two strings `s` and `t`, return `true` if `s` is a subsequence of `t`, or `false` otherwise. A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

### Examples

**Example 1:**
- **Input**: `s = "abc"`, `t = "ahbgdc"`
- **Output**: `true`

**Example 2:**
- **Input**: `s = "axc"`, `t = "ahbgdc"`
- **Output**: `false`

### Constraints
- 0 <= s.length <= 100
- 0 <= t.length <= 104
- s and t consist only of lowercase English letters.

### Follow-up
Suppose there are lots of incoming `s`, say `s1`, `s2`, ..., `sk` where `k >= 109`, and you want to check one by one to see if `t` has its subsequence. In this scenario, how would you change your code?

[LeetCode Problem URL](https://leetcode.com/problems/is-subsequence/)

## Solution

```java

package com.ib.p02_twopointer;

public class LP11IsSubSequence {

	public static void main(String[] args) {
		System.out.println(new Solution11().isSubsequence("abc", "ahbdc"));
	}
}

class Solution11 {
	/*-
	 * Aim is to find if the s is substr of t i.e s can be created by deleting any or non char of t
	 * 
	 * Easy and cool idea:
	 * 	loop for bigger length string
	 * 	start a pointer with 0
	 *  compare if any char matched the small str if it does increase pointer...
	 *  check if pointer length equals substr length if yes return true.
	 *  abcde -> ace is substr but not aec
	 * 
	 */
	public boolean isSubsequence(String s, String t) {
		int subLength = s.length();
		if (subLength <= 0)
			return true;
		char[] sCharArr = s.toCharArray();
		char[] tCharArr = t.toCharArray();

		int i = 0, j = 0;
		while (i < t.length()) {
			if (tCharArr[i] == sCharArr[j]) {
				j++;
			}
			if (j == subLength)
				return true;
			i++;
		}
		return false;
	}
}