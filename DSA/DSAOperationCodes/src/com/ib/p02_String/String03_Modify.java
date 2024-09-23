package com.ib.p02_String;

public class String03_Modify {

	public static void main(String args[]) {

		// Get the String
		String str = "Geeks Gor Geeks";

		// Get the index
		int index = 6;

		// Get the character
		char ch = 'F';

		// Print the original string
		System.out.println("Original String = " + str);

		str = str.substring(0, index) + ch + str.substring(index + 1);

		// Print the modified string
		System.out.println("Modified String = " + str);
	}
}
