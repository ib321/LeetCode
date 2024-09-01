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