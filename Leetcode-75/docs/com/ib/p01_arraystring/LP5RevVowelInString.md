# 345. Reverse Vowels of a String

**Difficulty**: Easy

## Problem Statement
Given a string `s`, reverse only all the vowels in the string and return it. The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

### Examples

**Example 1:**
- **Input**: `s = "hello"`
- **Output**: `"holle"`

**Example 2:**
- **Input**: `s = "leetcode"`
- **Output**: `"leotcede"`

### Constraints
- 1 <= s.length <= 3 * 105
- `s` consists of printable ASCII characters.

## Solution

```java


package com.ib.p01_arraystring;

import java.util.ArrayList;
import java.util.List;

public class LP5RevVowelInString {

	public static void main(String[] args) {
		System.out.println(new Solution5().reverseVowels2("leetcode")); //"leotcede"
	}
}

class Solution5 {

	/**
	 * Approach:
	 * 	first extract all vowels in an char array.
	 * 	loop StringToChar in reverse and check if vowel add into vowels list
	 * 	this gives the reversed char array list
	 * 	again loop array: check if vowel: replace current element with the first revVowels array.
	 * @param s : string whose vowel is to be reversed
	 * @return new string with it's only vowel reversed.
	 */
	public String reverseVowels(String s) {
		char[] stringToChar = s.toCharArray();
		List<Character> revVowels = new ArrayList<Character>();

		for (int i = s.length() - 1; i >= 0; i--) {
			char c = stringToChar[i];
			if (isVowel(c)) {
				revVowels.add(c);
			}
		}
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = stringToChar[i];
			if (isVowel(c)) {
				stringToChar[i] = revVowels.get(index++);
			}
		}
		return String.valueOf(stringToChar);
	}

	/**
	 * using indexOf function of string if it contain that char it returns non -1
	 * if it doesn't returns -1;
	 * @param c
	 * @return
	 */
	private boolean isVowel(char c) {
		String vowels = "aeiouAEIOU";
		return vowels.indexOf(c) != -1;
	}


	/**
	 * Two pointers, left and right initialized at 0 and last-1
	 * while left < right : move left++ and right-- one steps
	 * move left++ until it find a vowel at left
	 * then move right-- until it finds a vowel
	 * so this way if both points to vowel
	 * reverse both char :
	 * 	store char[left] on temp
	 * 	put char[right] into char[left]
	 * 	put temp into char[right]
	 * 	now do both left++ and right--;
	 * @param s
	 * @return
	 */
	public String reverseVowels2(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (!isVowel(chars[left])) {
                left++;
                continue;
            }
            if (!isVowel(chars[right])) {
                right--;
                continue;
            }
            // Swap vowels
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
	
	private boolean isVowel2(char[] stringToChar, int i) {
		boolean isSmallVowels = stringToChar[i] == 'a' || stringToChar[i] == 'e' || stringToChar[i] == 'i'
				|| stringToChar[i] == 'o' || stringToChar[i] == 'u';
		boolean isCapVowels = stringToChar[i] == 'A' || stringToChar[i] == 'E' || stringToChar[i] == 'I'
				|| stringToChar[i] == 'O' || stringToChar[i] == 'U';
		return isSmallVowels || isCapVowels;
	}
}