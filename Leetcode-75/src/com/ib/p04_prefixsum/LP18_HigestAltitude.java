package com.ib.p04_prefixsum;

import java.util.Arrays;

public class LP18_HigestAltitude {

	public static void main(String[] args) {
		System.out.println(new Solution18().largestAltitude(new int[] { -5, 1, 5, 0, -7 }));
	}
}

class Solution18 {
	/**
	 * Approach is as this given array is just the gain in altitude
	 * First we will find the new array with altitude by adding the i and i+1 altitudes.
	 * then find out the max in new Altitudes Array.
	 * @param gain
	 * @return
	 */
	public int largestAltitude(int[] gain) {
		int length = gain.length;
		int[] altitudes = new int[length + 1];
		int sum = 0;
		
		for (int i = 0; i < length; i++) {
			altitudes[i] = sum;
			sum = sum + gain[i];
			if (i == length - 1)
				altitudes[i + 1] = sum;
		}
		int maxAltitude = Integer.MIN_VALUE;
		for (int alti : altitudes) {
			if (alti > maxAltitude)
				maxAltitude = alti;
		}
		//System.out.println(Arrays.toString(altitudes));
		return maxAltitude;
	}
}