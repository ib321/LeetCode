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