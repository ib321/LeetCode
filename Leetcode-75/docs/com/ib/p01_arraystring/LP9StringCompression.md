# 443. String Compression

**Difficulty**: Medium

## Problem Statement
Given an array of characters `chars`, compress it using the following algorithm:
Begin with an empty string `s`. For each group of consecutive repeating characters in `chars`:
- If the group's length is 1, append the character to `s`.
- Otherwise, append the character followed by the group's length.

The compressed string `s` should not be returned separately, but instead, be stored in the input character array `chars`. Note that group lengths that are 10 or longer will be split into multiple characters in `chars`. After you are done modifying the input array, return the new length of the array. You must write an algorithm that uses only constant extra space.

### Examples

**Example 1:**
- **Input**: `chars = ["a","a","b","b","c","c","c"]`
- **Output**: Return 6, and the first 6 characters of the input array should be: `["a","2","b","2","c","3"]`
- **Explanation**: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

**Example 2:**
- **Input**: `chars = ["a"]`
- **Output**: Return 1, and the first character of the input array should be: `["a"]`
- **Explanation**: The only group is "a", which remains uncompressed since it's a single character.

**Example 3:**
- **Input**: `chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]`
- **Output**: Return 4, and the first 4 characters of the input array should be: `["a","b","1","2"]`
- **Explanation**: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".

### Constraints
- 1 <= chars.length <= 2000
- chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

## Solution

```java

package com.ib.p01_arraystring;

import java.util.Arrays;

public class LP9StringCompression {

	public static void main(String[] args) {
		new Solution9().compress(new char[] { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' });
		new Solution9().compress(new char[] { 'a', 'b', 'b', 'c', 'c', 'c' });

	}

}

class Solution9 {
	
	// from leetcode solutions
	public int compress2(char[] chars) {
		int ans = 0; // keep track of current position in compressed array

		// iterate through input array using i pointer
		for (int i = 0; i < chars.length;) {
			final char letter = chars[i]; // current character being compressed
			int count = 0; // count of consecutive occurrences of letter

			// count consecutive occurrences of letter in input array
			while (i < chars.length && chars[i] == letter) {
				++count;
				++i;
			}

			// write letter to compressed array
			chars[ans++] = letter;

			// if count is greater than 1, write count as string to compressed array
			if (count > 1) {
				// convert count to string and iterate over each character in string
				for (final char c : String.valueOf(count).toCharArray()) {
					chars[ans++] = c;
				}
			}
		}

		// return length of compressed array
		return ans;
	}

	// Raw logic
	public int compress(char[] chars) {
		int count = 0;
		int index = 0;

		char letter = chars[0];
		chars[index++] = letter;
		for (int i = 0; i < chars.length; i++) {

			if (letter == chars[i]) {
				count++;
			} else {

				if (count > 1) {
					String countString = Integer.toString(count);
					for (int j = 0; j < countString.length(); j++) {
						chars[index++] = countString.charAt(j);
					}
				}

				letter = chars[i];
				chars[index++] = letter;
				count = 1;
			}
			if (i == chars.length - 1) {
				if (count > 1) {
					String countString = Integer.toString(count);
					for (int j = 0; j < countString.length(); j++) {
						chars[index++] = countString.charAt(j);
					}
				}
			}
		}
		System.out.println(Arrays.toString(chars));
		System.out.println(index);
		return index;
	}


	public int compress3(char[] chars) {
		if (chars.length == 0)
			return 0;

		int index = 0;
		int count = 1;

		for (int i = 1; i <= chars.length; i++) {
			if (i < chars.length && chars[i] == chars[i - 1]) {
				count++;
			} else {
				chars[index++] = chars[i - 1];
				if (count > 1) {
					String countStr = Integer.toString(count);
					for (char c : countStr.toCharArray()) {
						chars[index++] = c;
					}
				}
				count = 1; // Reset count for the next character
			}
		}

		System.out.println(Arrays.toString(chars));
		System.out.println(index);
		return index;
	}
}