package com.ib.p01_arraystring;

import java.util.Arrays;

public class LP9StringCompression {

	public static void main(String[] args) {
		new Solution9().compress(new char[] { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' });
		new Solution9().compress(new char[] { 'a', 'b', 'b', 'c', 'c', 'c' });

	}

}

class Solution9 {
	
	public int compress2(char[] chars) {
		int ans = 0; // keep track of current position in compressed array

		// iterate through input array using i pointer
		for (int i = 0; i < chars.length;) {
			final char letter = chars[i]; // current character being compressed
			int count = 0; // count of consecutive occurrences of letter

			// count consecutive occurrences of letter in input array
			while (i < chars.length && chars[i] == letter) {
				++count;
				++i;
			}

			// write letter to compressed array
			chars[ans++] = letter;

			// if count is greater than 1, write count as string to compressed array
			if (count > 1) {
				// convert count to string and iterate over each character in string
				for (final char c : String.valueOf(count).toCharArray()) {
					chars[ans++] = c;
				}
			}
		}

		// return length of compressed array
		return ans;
	}

	// Raw logic
	public int compress(char[] chars) {
		int count = 0;
		int index = 0;

		char letter = chars[0];
		chars[index++] = letter;
		for (int i = 0; i < chars.length; i++) {

			if (letter == chars[i]) {
				count++;
			} else {

				if (count > 1) {
					String countString = Integer.toString(count);
					for (int j = 0; j < countString.length(); j++) {
						chars[index++] = countString.charAt(j);
					}
				}

				letter = chars[i];
				chars[index++] = letter;
				count = 1;
			}
			if (i == chars.length - 1) {
				if (count > 1) {
					String countString = Integer.toString(count);
					for (int j = 0; j < countString.length(); j++) {
						chars[index++] = countString.charAt(j);
					}
				}
			}
		}
		System.out.println(Arrays.toString(chars));
		System.out.println(index);
		return index;
	}


	public int compress3(char[] chars) {
		if (chars.length == 0)
			return 0;

		int index = 0;
		int count = 1;

		for (int i = 1; i <= chars.length; i++) {
			if (i < chars.length && chars[i] == chars[i - 1]) {
				count++;
			} else {
				chars[index++] = chars[i - 1];
				if (count > 1) {
					String countStr = Integer.toString(count);
					for (char c : countStr.toCharArray()) {
						chars[index++] = c;
					}
				}
				count = 1; // Reset count for the next character
			}
		}

		System.out.println(Arrays.toString(chars));
		System.out.println(index);
		return index;
	}
}