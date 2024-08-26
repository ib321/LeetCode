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
