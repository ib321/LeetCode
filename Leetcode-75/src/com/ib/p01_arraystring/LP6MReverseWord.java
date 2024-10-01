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