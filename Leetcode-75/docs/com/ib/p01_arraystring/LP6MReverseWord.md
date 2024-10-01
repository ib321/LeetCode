# 151. Reverse Words in a String

**Difficulty**: Medium

## Problem Statement
Given an input string `s`, reverse the order of the words. A word is defined as a sequence of non-space characters. The words in `s` will be separated by at least one space. Return a string of the words in reverse order concatenated by a single space. Note that `s` may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

### Examples

**Example 1:**
- **Input**: `s = "the sky is blue"`
- **Output**: `"blue is sky the"`

**Example 2:**
- **Input**: `s = "  hello world  "`
- **Output**: `"world hello"`
- **Explanation**: Your reversed string should not contain leading or trailing spaces.

**Example 3:**
- **Input**: `s = "a good   example"`
- **Output**: `"example good a"`
- **Explanation**: You need to reduce multiple spaces between two words to a single space in the reversed string.

### Constraints
- 1 <= s.length <= 104
- s contains English letters (upper-case and lower-case), digits, and spaces ' '.
- There is at least one word in s.

### Follow-up
If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?

## Solution

```java

package com.ib.p01_arraystring;

public class LP6MReverseWord {

	public static void main(String[] args) {
		new Solution6().reverseWords("the sky    is blue"); //"blue is sky the"
	}
}

class Solution6 {
	/**
	 * Approach:
	 * 	split the sentence with String split method on basis of " "
	 * 	we get splited words arrays it will have all the words combined with some blank words
	 * 	reverse the order of words by using loop in reverse:: only append if word is not empty
	 * 	at last return the string wait you forgot the trailing space (trim that)
	 * 
	 * @param s : sentence string where words are to be reversed
	 * @return String of reversed word
	 */
	public String reverseWords(String s) {
		String[] splitarr = s.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = splitarr.length - 1; i >= 0; i--) {
			String str = splitarr[i];
			if (!str.isEmpty())
				result.append(str).append(" ");
		}
		String string = result.toString();
		System.out.println(string.trim());
		return string.trim();
	}
}