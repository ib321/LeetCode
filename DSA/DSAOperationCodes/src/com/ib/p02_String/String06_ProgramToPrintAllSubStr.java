package com.ib.p02_String;

//Java program to print all possible
//substrings of a given string

/**
 * 
 * Input : abcd Output : a b c d ab bc cd abc bcd abcd
 */
public class String06_ProgramToPrintAllSubStr {

	public static void printSubstrings(String str) {
		int n = str.length();
		// Loop through all possible starting points
		for (int i = 0; i < n; i++) {
			// Loop through all possible ending points
			for (int j = i + 1; j <= n; j++) {
				// Print the substring from index i to j
				System.out.println(str.substring(i, j));
			}
		}
	}
	
	public static void printSubstrings2(String str) {
        int n = str.length();
        // Loop through all possible lengths
        for (int length = 1; length <= n; length++) {
            // Loop through all possible starting points for the current length
            for (int i = 0; i <= n - length; i++) {
                // Print the substring from index i to i+length
                System.out.println(str.substring(i, i + length));
            }
        }
    }

//Driver program to test above function
	public static void main(String[] args) {
		printSubstrings2("abcd");
		printSubstrings("abcd");

	}
}
