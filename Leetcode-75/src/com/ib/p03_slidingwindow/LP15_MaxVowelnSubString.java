package com.ib.p03_slidingwindow;

public class LP15_MaxVowelnSubString {

	public static void main(String[] args) {
		System.out.println(new Solution15().maxVowels("abciiidef", 4));
	}
}

class Solution15 {
	public int maxVowels(String s, int k) {

		char[] strCharArr = s.toCharArray();
		int currVowelCount = 0;
		for (int i = 0; i < k; i++) {
			boolean isVowel = strCharArr[i] == 'a' || strCharArr[i] == 'e' || strCharArr[i] == 'i'
					|| strCharArr[i] == 'o' || strCharArr[i] == 'u';
			if (isVowel)
				currVowelCount++;
		}
		int maxVowelCount = currVowelCount;

		for (int i = k; i < strCharArr.length; i++) {
			boolean isNextCharVowel = strCharArr[i] == 'a' || strCharArr[i] == 'e' || strCharArr[i] == 'i'
					|| strCharArr[i] == 'o' || strCharArr[i] == 'u';
			if (isNextCharVowel)
				currVowelCount++;
			boolean wasPrevCharVowel = strCharArr[i - k] == 'a' || strCharArr[i - k] == 'e' || strCharArr[i - k] == 'i'
					|| strCharArr[i - k] == 'o' || strCharArr[i - k] == 'u';
			if (wasPrevCharVowel)
				currVowelCount--;
			if (currVowelCount > maxVowelCount)
				maxVowelCount = currVowelCount;
		}
		return maxVowelCount;
	}
}
