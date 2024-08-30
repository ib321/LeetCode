package com.ib.p01_arraystring;

import java.util.Arrays;

public class LP9StringCompression {

	public static void main(String[] args) {
		// new Solution9().compress(new char[] { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b',
		// 'b', 'b', 'b', 'b', 'b', 'b' });
		new Solution9().compress(new char[] { 'a', 'b', 'b', 'c', 'c', 'c' });

	}

}

class Solution9 {
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
}