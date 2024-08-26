# 1768. Merge Strings Alternately

**Difficulty**: Easy

## Problem Statement
You are given two strings `word1` and `word2`. Merge the strings by adding letters in alternating order, starting with `word1`. If a string is longer than the other, append the additional letters onto the end of the merged string. Return the merged string.

### Examples

**Example 1:**
- **Input**: `word1 = "abc"`, `word2 = "pqr"`
- **Output**: `"apbqcr"`
- **Explanation**: The merged string will be merged as so:
word1: a b c word2: p q r merged: a p b q c r


**Example 2:**
- **Input**: `word1 = "ab"`, `word2 = "pqrs"`
- **Output**: `"apbqrs"`
- **Explanation**: Notice that as `word2` is longer, "rs" is appended to the end.

word1: a b word2: p q r s merged: a p b q r s


**Example 3:**
- **Input**: `word1 = "abcd"`, `word2 = "pq"`
- **Output**: `"apbqcd"`
- **Explanation**: Notice that as `word1` is longer, "cd" is appended to the end.

word1: a b c d word2: p q merged: a p b q c d


### Constraints
- 1 <= word1.length, word2.length <= 100
- `word1` and `word2` consist of lowercase English letters.

## Solution

```java

package com.ib.arraystring;

public class LP1MergeStringAlternatevely {

	public static void main(String[] args) {
		new Solution1().mergeAlternately("abcdef", "123456789");
	}

}

class Solution1 {

	public String mergeAlternately(String word1, String word2) {

		char[] chararr1 = word1.toCharArray();
		char[] chararr2 = word2.toCharArray();

		char[] bigone = chararr1;
		char[] smallone = chararr2;

		if (word2.length() > word1.length()) {
			bigone = chararr2;
			smallone = chararr1;
		}

		char[] result = new char[chararr1.length + chararr2.length];

		int index = 0;
		for (int i = 0; i < smallone.length; i++) {
			result[index++] = chararr1[i];
			result[index++] = chararr2[i];
		}
		//System.out.println(index);
		for (int i = smallone.length; i < bigone.length; i++) {
			result[index++] = bigone[i];
		}
		String out = new String(result);
		//System.out.println(out);
		return out;
	}
}
