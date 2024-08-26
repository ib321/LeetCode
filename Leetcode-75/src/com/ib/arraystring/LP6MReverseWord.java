package com.ib.arraystring;

public class LP6MReverseWord {

	public static void main(String[] args) {
		new Solution6().reverseWords("the sky    is blue");

	}

}

class Solution6 {
	public String reverseWords(String s) {
		String[] splitarr = s.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = splitarr.length - 1; i >= 0; i--) {
			String str = splitarr[i];
			if(!str.isEmpty())
				result.append(str + " ");
		}
		String string = result.toString();
		System.out.println(string.trim());
		return string.trim();
	}
}