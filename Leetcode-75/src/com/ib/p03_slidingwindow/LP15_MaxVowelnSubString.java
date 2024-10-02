package com.ib.p03_slidingwindow;

public class LP15_MaxVowelnSubString {

	public static void main(String[] args) {
		System.out.println(new Solution15().maxVowels("abciiidef", 4));
	}
}

class Solution15 {
	
	public boolean isVowel(char c) {
		return "aeiouAEIOU".indexOf(c) != -1;
	}
	
	/*- ("abciiidef", 4)
	 * 
	 * @param s = string where we max vowel needs to be found
	 * @param k = window size 
	 * @return : number of max vowel found in that window
	 */
	public int maxVowels(String s, int k) {
		char[] strCharArr = s.toCharArray();
		int currVowelCount = 0;

		// find how many vowel are in first window size (abci) : count = 1
		for (int i = 0; i < k; i++) {
			if (isVowel(strCharArr[i]))
				currVowelCount++;
		}
		// store current counted vowels to max it will be update if we find more
		int maxVowelCount = currVowelCount;

		// loop for sliding window
		for (int i = k; i < strCharArr.length; i++) {
			// last loop was till <k so 3 now this start with k so 4: next char is i
			// check if next char is vowel if yes increase the vowel count
			boolean isNextCharVowel = isVowel(strCharArr[i]);
			if (isNextCharVowel)
				currVowelCount++;
			// check if prev char which is now left as window slided was a vowel if yes then we need to reduce the count
			// prev char for i  at k will be 'a'
			int prevCharIndex = i - k;
			boolean wasPrevCharVowel = isVowel(strCharArr[prevCharIndex]);
			if (wasPrevCharVowel)
				currVowelCount--;

			// if count is more then max update
			if (currVowelCount > maxVowelCount)
				maxVowelCount = currVowelCount;
		}
		return maxVowelCount;
	}
}


class Solution2{
	public int maxVowelsOLDWay(String s, int k) {
		char[] strCharArr = s.toCharArray();
		int currVowelCount = 0;
		// Checking only with lower case vowel letters assuming input always will be in lowercase.
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
			int prevCharIndex = i - k;
			boolean wasPrevCharVowel = strCharArr[prevCharIndex] == 'a' || strCharArr[prevCharIndex] == 'e' || strCharArr[prevCharIndex] == 'i'
					|| strCharArr[prevCharIndex] == 'o' || strCharArr[prevCharIndex] == 'u';
			if (wasPrevCharVowel)
				currVowelCount--;
			if (currVowelCount > maxVowelCount)
				maxVowelCount = currVowelCount;
		}
		return maxVowelCount;
	}
}
