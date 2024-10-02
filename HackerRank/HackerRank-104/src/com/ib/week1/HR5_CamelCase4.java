package com.ib.week1;

import java.util.*;

public class HR5_CamelCase4 {

	/**
	 * I think this wasn't working anyway need to check again
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(str);
		StringBuilder sb = new StringBuilder();

		String[] strArr = str.split(";");
		// System.out.println(strArr.toString());
		if (strArr[1].equalsIgnoreCase("M")) {
			if (strArr[0].equalsIgnoreCase("S")) {

				for (char c : strArr[2].toCharArray()) {
					if (Character.isUpperCase(c)) {
						sb.append(" ");
						sb.append(Character.toLowerCase(c));
					} else if (Character.isLowerCase(c) || Character.isDigit(c))
						sb.append(Character.toLowerCase(c));
				}

				System.out.println(sb.toString());
			} else if (strArr[0].equalsIgnoreCase("C")) {
				String[] arrStr = strArr[2].split(" ");

				for (int i = 0; i < arrStr.length; i++) {
					String word = arrStr[i];
					if (i == 0)
						sb.append(word.toLowerCase());
					else {

						sb.append(Character.toUpperCase(word.charAt(0)));
						sb.append(word.substring(1).toLowerCase());
					}
				}
				sb.append("()");
				System.out.println(sb);
			}

		} else if (strArr[1].equalsIgnoreCase("V")) {

		} else if (strArr[1].equalsIgnoreCase("C")) {

		}
		sc.close();
	}
}