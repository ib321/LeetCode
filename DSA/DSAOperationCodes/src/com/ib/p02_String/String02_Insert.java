package com.ib.p02_String;

public class String02_Insert {
	public static void main(String[] args) {
		String str = "GeeksGeeks ";
		String ch = "for";
		int k = 5;

		System.out.println("Original String: " + str);
		insertDemo(str, ch, k);
	}

	// Function to demonstrate insert
	public static void insertDemo(String str, String ch, int k) {
		// Inserts ch at kth index of str
		StringBuilder sb = new StringBuilder(str);
		sb.insert(k, ch);
		String modifiedString = sb.toString();
		System.out.println("Modified String: " + modifiedString);
	}
}
