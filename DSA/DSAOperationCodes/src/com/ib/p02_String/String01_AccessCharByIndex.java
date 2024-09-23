package com.ib.p02_String;

public class String01_AccessCharByIndex {

	// Function to demonstrate accessCharByIndex
	public static char accessCharByIndex(String str, int k) {

		// Return the character at the k-th index in the string str
		return str.charAt(k);
	}

	// Driver code
	public static void main(String[] args) {
		String str = "GeeksforGeeks ";
		int k = 4;
		System.out.println(accessCharByIndex(str, k));
	}
}
