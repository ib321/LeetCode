package com.ib.p01_arraystring;

import java.util.ArrayList;
import java.util.List;

public class LP5RevVowelInString {

	public static void main(String[] args) {

		System.out.println(new Solution5().reverseVowels2("leetcode"));
		;

	}

}

class Solution5 {
	public String reverseVowels(String s) {

		char[] resultchararr = new char[s.length()];
		char[] stringToChar = s.toCharArray();

		List<Character> vowels = new ArrayList<Character>();

		for (int i = s.length() - 1; i >= 0; i--) {
			boolean isSmallVowels = stringToChar[i] == 'a' || stringToChar[i] == 'e' || stringToChar[i] == 'i'
					|| stringToChar[i] == 'o' || stringToChar[i] == 'u';
			boolean isCapVowels = stringToChar[i] == 'A' || stringToChar[i] == 'E' || stringToChar[i] == 'I'
					|| stringToChar[i] == 'O' || stringToChar[i] == 'U';
			if (isSmallVowels || isCapVowels) {
				vowels.add(stringToChar[i]);
			}
		}

		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			resultchararr[i] = stringToChar[i];
			boolean isSmallVowels = stringToChar[i] == 'a' || stringToChar[i] == 'e' || stringToChar[i] == 'i'
					|| stringToChar[i] == 'o' || stringToChar[i] == 'u';
			boolean isCapVowels = stringToChar[i] == 'A' || stringToChar[i] == 'E' || stringToChar[i] == 'I'
					|| stringToChar[i] == 'O' || stringToChar[i] == 'U';
			if (isSmallVowels || isCapVowels) {
				resultchararr[i] = vowels.get(index++);
			}
		}
		System.out.println(String.valueOf(resultchararr));
		return String.valueOf(resultchararr);
	}

	public String reverseVowels2(String s) {
		StringBuilder sb = new StringBuilder(s);
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(j);
			if (ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u' || ch1 == 'A' || ch1 == 'E'
					|| ch1 == 'I' || ch1 == 'O' || ch1 == 'U') {
				if (ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u' || ch2 == 'A' || ch2 == 'E'
						|| ch2 == 'I' || ch2 == 'O' || ch2 == 'U') {
					sb.setCharAt(i, ch2);
					sb.setCharAt(j, ch1);
					i++;
				}
				j--;
			} else {
				i++;
			}
		}
		return sb.toString();
	}
}