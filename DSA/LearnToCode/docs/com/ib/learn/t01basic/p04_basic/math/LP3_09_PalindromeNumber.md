# 9. Palindrome Number

**Difficulty**: Easy

## Problem Statement
Given an integer x, return true if x is a palindrome, and false otherwise.

### Examples

**Example 1:**
- **Input:** x = 121
- **Output:** true
- **Explanation:** 121 reads as 121 from left to right and from right to left.

**Example 2:**
- **Input:** x = -121
- **Output:** false
- **Explanation:** From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

**Example 3:**
- **Input:** x = 10
- **Output:** false
- **Explanation:** Reads 01 from right to left. Therefore it is not a palindrome.

### Constraints
- -2^31 <= x <= 2^31 - 1

### Follow Up
Could you solve it without converting the integer to a string?

### Topics
- Math

### Hints
1. Beware of overflow when you reverse the integer.

## Solution

```java
package com.ib.learn.p01_basic.t1_math;

public class LP3_09_PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(new SolutionLP03().isPalindrome(121)); //true
		System.out.println(new SolutionLP03().isPalindrome(-121)); // false
		System.out.println(new SolutionLP03().isPalindrome(10));//false
		System.out.println(new SolutionLP03().isPalindrome(2112)); // true
	}

}

class SolutionLP03 {
	// will follow long and int check way for this reverse
	public boolean isPalindrome(int x) {
		// if negative:: -121 reverse id 121- which is not Equal
		if (x < 0)
			return false;
		// using long instead of int.
		long newnum = x;
		long revnum = 0;
		// reverse algo same as int without overflow check
		while (newnum != 0) {
			long rem = newnum % 10;
			revnum = revnum * 10 + rem;
			newnum = newnum / 10;
		}
		int revint = (int) revnum;
		// overflow check here if revnum == revint condition is to check if
		// int counterpart of long is same if yes then no overflow happened
		// 2nd condition to check for Palindrome
		if (revnum == revint && x == revint) {
			return true;
		} else {
			return false;
		}
	}
}