package com.ib.p02_String;

public class String04_DeleteChar {
	// Function to remove a particular character
	// from a character array
	// Parameters:
	// - s: the character array from which
	// the character will be removed
	// - c: the character to be removed
	public static void removeChar(char[] s, char c) {
		// Initialize a pointer j to keep track of the
		// position where characters are being moved
		int j = 0;
		// Loop through the character array
		for (int i = 0; i < s.length; i++) {
			// If the current character is
			// not the one to be removed
			if (s[i] != c) {
				// Move the character to the
				// position indicated by j
				s[j++] = s[i];
			}
		}
		// Fill the remaining positions with null characters ('\0')
		while (j < s.length) {
			s[j++] = '\0';
		}
	}

	public static void main(String[] args) {
		// Input string as a character array
		char[] s = "geeksforgeeks".toCharArray();
		// Remove character 'g' from the string
		removeChar(s, 'g');
		// Print the modified string
		System.out.println(s);
	}
}
