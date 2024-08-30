package com.ib.p02_twopointer;

public class LP11IsSubSequence {

	public static void main(String[] args) {
		System.out.println(new Solution11().isSubsequence("abc", "ahbdc"));
	}
}

class Solution11 {
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