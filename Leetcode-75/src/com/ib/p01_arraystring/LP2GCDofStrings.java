package com.ib.p01_arraystring;

public class LP2GCDofStrings {

	public static void main(String[] args) {

		System.out.println(new Solution2().gcdOfStrings("ABABAB", "ABAB"));

	}
}

class Solution2 {
	 
	public String gcdOfStrings(String str1, String str2) {

		if (!((str1 + str2).equals(str2 + str1)))
			return "";
		int a = str1.length();
		int b = str2.length();

		int small = a;
		if (b < small)
			small = b;
		int gcd = 1;
		for (int i = small; i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				gcd = i;
				break;
			}
		}
		String GCD = str1.substring(0, gcd);
		return GCD;
	}
	
	// Didn't worked try another logic
	public String gcdOfStrings0(String str1, String str2) {
		String Smallstr = str1;
		String BigStr = str2;
		if (str2.length() < str1.length()) {
			Smallstr = str2;
			BigStr = str1;
		}
		StringBuilder GCD = new StringBuilder();
		for (int i = 0; i < Smallstr.length(); i++) {
			String letter = String.valueOf(Smallstr.charAt(i));
			if (BigStr.contains(letter) && Smallstr.contains(letter)) {
				GCD.append(letter);
			}
		}
		return GCD.toString();
	}
}