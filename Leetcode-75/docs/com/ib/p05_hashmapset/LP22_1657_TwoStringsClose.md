# 1657. Determine if Two Strings Are Close

**Difficulty**: Medium

## Problem Statement
Two strings are considered close if you can attain one from the other using the following operations:

- **Operation 1**: Swap any two existing characters. For example, `abcde` -> `aecdb`
- **Operation 2**: Transform every occurrence of one existing character into another existing character, and do the same with the other character. For example, `aacabb` -> `bbcbaa` (all `a`s turn into `b`s, and all `b`s turn into `a`s)

You can use the operations on either string as many times as necessary.

Given two strings, `word1` and `word2`, return `true` if `word1` and `word2` are close, and `false` otherwise.

### Examples

**Example 1:**
- **Input**: `word1 = "abc"`, `word2 = "bca"`
- **Output**: `true`
- **Explanation**: You can attain `word2` from `word1` in 2 operations. Apply Operation 1: `"abc"` -> `"acb"`. Apply Operation 1: `"acb"` -> `"bca"`.

**Example 2:**
- **Input**: `word1 = "a"`, `word2 = "aa"`
- **Output**: `false`
- **Explanation**: It is impossible to attain `word2` from `word1`, or vice versa, in any number of operations.

**Example 3:**
- **Input**: `word1 = "cabbba"`, `word2 = "abbccc"`
- **Output**: `true`
- **Explanation**: You can attain `word2` from `word1` in 3 operations. Apply Operation 1: `"cabbba"` -> `"caabbb"`. Apply Operation 2: `"caabbb"` -> `"baaccc"`. Apply Operation 2: `"baaccc"` -> `"abbccc"`.

### Constraints
- 1 <= word1.length, word2.length <= 10^5
- `word1` and `word2` contain only lowercase English letters.

### Topics
- Hash Table
- String
- Sorting
- Counting

### Hints
1. Operation 1 allows you to freely reorder the string.
2. Operation 2 allows you to freely reassign the letters' frequencies.

[LeetCode Problem URL](https://leetcode.com/problems/determine-if-two-strings-are-close/)

## Solution

```java

package com.ib.p05_hashmapset;

import java.util.*;

public class LP22_1657_TwoStringsClose {

	public static void main(String[] args) {
		System.out.println(new Solution22().closeStrings("cabbba", "abbccc"));
		System.out.println(new Solution22().closeStrings2("cabbbaa", "abbcccd"));

	}

}

class Solution22 {
	/**
	 * Goal is to find if two Strings are close.
	 * Close String are if you get the new string by: 
	 * 	if you can swap any character and get::
	 * 	or change every occurrence of one existing character into another existing character
	 * 
	 * Approach:
	 * Basically::
	 * To determine if two strings are close, Focus on two main aspects:
	 * 	Both strings must contain the exact same set of unique characters.
	 * 	The frequency distribution of char in both strings must be the same, though the char themselves can differ.
	 * 
	 * 1. Check Unique Characters: First, check if both strings contain the same set of unique characters.
	 *  							If not, they cannot be close.
	 * 2. Check Frequency Distribution: Calculate the frequency of each character in both strings.
	 * 		 Sort these frequencies and compare them. If they match, the strings are close; otherwise,not.
	 * @param word1
	 * @param word2
	 * @return
	 */
	public boolean closeStrings(String word1, String word2) {
		if(word1.length() != word2.length()) return false;
		HashMap<Character, Integer> word1CharMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> word2CharMap = new HashMap<Character, Integer>();
		for (int i = 0; i < word1.length(); i++) {
			word1CharMap.put(word1.charAt(i), word1CharMap.getOrDefault(word1.charAt(i), 0)+1);
			word2CharMap.put(word2.charAt(i), word2CharMap.getOrDefault(word2.charAt(i), 0)+1);
		}
		System.out.println(word1CharMap.toString());
		System.out.println(word2CharMap.toString());
		
		HashSet<Character> charSet1 = new HashSet<Character>();
		HashSet<Character> charSet2 = new HashSet<Character>();
		for(Character wordChar : word1CharMap.keySet()){
			charSet1.add(wordChar);
		}
		for(Character wordChar : word2CharMap.keySet()){
			charSet2.add(wordChar);
		}
		System.out.println(charSet1.toString());
		System.out.println(charSet2.toString());
		// Check if these both char set contain same unique char
		if (!charSet1.equals(charSet2)) return false;
		
		List<Integer> charFreqList1 = new ArrayList<>(word1CharMap.values());
        List<Integer> charFreqList2 = new ArrayList<>(word2CharMap.values());
        Collections.sort(charFreqList1);
        Collections.sort(charFreqList2);
        
        System.out.println(charFreqList1.toString());
		System.out.println(charFreqList2.toString());
        if (!charFreqList1.equals(charFreqList2)) return false;
		return true;
	}
	

	/**
	 * Goal n Approach are same method is different here
	 * More optimized method and not using Sort Map and all.
	 * Creates Two Array of size 26 to store corr. char freq to that place
	 * Now we have an 26 size array with frequency for each char.
	 * check 1st condition:: logic::
	 * if first array has doesn't have a letter at i and second does then they don't have same unique chars.
	 * 
	 * check 2nd condition::
	 * sort the frequency and both frequency should be same
	 * 
	 * @param word1
	 * @param word2
	 * @return
	 */
	public boolean closeStrings2(String word1, String word2) {
		int[] freq = new int[26];
		int[] freq2 = new int[26];
		// here ch - 'a' subtracting 'a' from char ch:: it output the index position of letter
		// like for ch = a ch - 'a' = 97 - 97 = 0; :: b - a = 98-97 = 1
		for (char ch : word1.toCharArray()) {
			freq[ch - 'a']++;
		}
		for (char ch : word2.toCharArray()) {
			freq2[ch - 'a']++;
		}
		System.out.println(Arrays.toString(freq));

		for (int i = 0; i < 26; i++) {
			if ((freq[i] == 0 && freq2[i] != 0) || (freq[i] != 0 && freq2[i] == 0))
				return false;
		}
		Arrays.sort(freq);
		Arrays.sort(freq2);
		for (int i = 0; i < 26; i++) {
			if (freq[i] != freq2[i]) {
				return false;
			}
		}
		return true;
	}
}