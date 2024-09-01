# 394. Decode String

**Difficulty**: Medium

## Problem Statement
Given an encoded string, return its decoded string.

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, `k`. For example, there will not be input like `3a` or `2[4]`.

The test cases are generated so that the length of the output will never exceed 10^5.

### Examples

**Example 1:**
- **Input**: `s = "3[a]2[bc]"`
- **Output**: `"aaabcbc"`

**Example 2:**
- **Input**: `s = "3[a2[c]]"`
- **Output**: `"accaccacc"`

**Example 3:**
- **Input**: `s = "2[abc]3[cd]ef"`
- **Output**: `"abcabccdcdcdef"`

### Constraints
- 1 <= s.length <= 30
- `s` consists of lowercase English letters, digits, and square brackets '[]'.
- `s` is guaranteed to be a valid input.
- All the integers in `s` are in the range [1, 300].

### Topics
- String
- Stack
- Recursion

## Solution

```java

package com.ib.p06_stack;

import java.util.*;

public class LP26_394_DecodeString {

	public static void main(String[] args) {
		//System.out.println(new Solution26().decodeString("3[a]2[bc]"));
		//System.out.println(new Solution26().decodeString("2[abc]3[cd]ef"));
		System.out.println(new Solution26().decodeString("100[leetcode]"));

	}

}

class Solution26 {
	/**
	 * Here Using almost brute force with Stack
	 * Logic is at first occurrence of ']' we will do actions
	 * 	1. find out the String b/w [ & ] :: pop stack & store into string until peek is '['
	 * 			reverse string as pop goes in reverse
	 * 	2. remove [
	 * 	3. find the number of time it need to be repeated :: pop and append until peek  > 0 or < 9
	 * 			reverse string and parse int from that
	 * 	4. create a string then push the string bw [] times above number
	 * 	5. push that string into char stack 
	 * 
	 * if not then they normally goes push into stack.
	 * 
	 * 
	 * @param s
	 * @return
	 */
    public String decodeString(String s) {
    	Stack<Character> stack = new Stack<Character>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
        	
        	if(charArr[i] == ']')
        	{
        		StringBuilder strInBracket = new StringBuilder();
        		while(!stack.isEmpty() && stack.peek() !='[')
        		{
        			strInBracket.append(stack.pop());
        		}
        		strInBracket.reverse();
        		//remove '['
        		stack.pop();
        		
        		StringBuilder repCountStr = new StringBuilder();
        		while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9')
        		{
        			repCountStr.append(stack.pop());
        		}
        		repCountStr.reverse();
        		int repCount = Integer.parseInt(repCountStr.toString());
        		StringBuilder strRep = new StringBuilder();
        		for(int k=1;k<=repCount;k++)
        		{
        			strRep.append(strInBracket);
        		}
        		String repeatedStr = strRep.toString();
        		for(int j=0;j<repeatedStr.length();j++)
        		{
        			
        			stack.push(repeatedStr.charAt(j));
        		}
        		
        	}else {
        		stack.push(charArr[i]);
        	}
		}
        
        System.out.println(stack.toString());
        StringBuilder output = new StringBuilder();
        for (char c : stack) {
			output.append(c);
		}
        return output.toString();
    }
}