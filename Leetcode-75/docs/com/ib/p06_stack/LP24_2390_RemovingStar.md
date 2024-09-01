# 2390. Removing Stars From a String

**Difficulty**: Medium

## Problem Statement
You are given a string `s`, which contains stars `*`.

In one operation, you can:
- Choose a star in `s`.
- Remove the closest non-star character to its left, as well as remove the star itself.

Return the string after all stars have been removed.

**Note**:
- The input will be generated such that the operation is always possible.
- It can be shown that the resulting string will always be unique.

### Examples

**Example 1:**
- **Input**: `s = "leet**cod*e"`
- **Output**: `"lecoe"`
- **Explanation**: Performing the removals from left to right:
  - The closest character to the 1st star is 't' in "leet**cod*e". `s` becomes "lee*cod*e".
  - The closest character to the 2nd star is 'e' in "lee*cod*e". `s` becomes "lecod*e".
  - The closest character to the 3rd star is 'd' in "lecod*e". `s` becomes "lecoe".
  - There are no more stars, so we return "lecoe".

**Example 2:**
- **Input**: `s = "erase*****"`
- **Output**: `""`
- **Explanation**: The entire string is removed, so we return an empty string.

### Constraints
- 1 <= s.length <= 10^5
- `s` consists of lowercase English letters and stars `*`.
- The operation above can be performed on `s`.

### Topics
- String
- Stack
- Simulation

### Hints
1. What data structure could we use to efficiently perform these removals?
2. Use a stack to store the characters. Pop one character off the stack at each star. Otherwise, we push the character onto the stack.

## Solution

```java

package com.ib.p06_stack;

import java.util.Stack;

public class LP24_2390_RemovingStar {

	public static void main(String[] args) {
		System.out.println(new Solution24().removeStars("leet**cod*e"));// lecoe
	}
}

class Solution24 {
	/**
	 * Goal is in given string remove the left most letter if * is encountered
	 * 
	 * Approach: Created one stack to push and pop: Looping through String if we
	 * find * we pop(it removes last char in stack) otherwise we push onto stack
	 * 
	 * @param s
	 * @return
	 */
	public String removeStars(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '*') {
				stack.pop();
			} else
				stack.push(c);
		}

		StringBuilder result = new StringBuilder(stack.size());
		for (char c : stack) {
			result.append(c);
		}
		return result.toString();
	}
}