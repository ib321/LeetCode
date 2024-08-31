# 1732. Find the Highest Altitude

**Difficulty**: Easy

## Problem Statement
There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
You are given an integer array `gain` of length `n` where `gain[i]` is the net gain in altitude between points `i` and `i + 1` for all `(0 <= i < n)`. Return the highest altitude of a point.

### Examples

**Example 1:**
- **Input**: `gain = [-5,1,5,0,-7]`
- **Output**: `1`
- **Explanation**: The altitudes are `[0,-5,-4,1,1,-6]`. The highest is `1`.

**Example 2:**
- **Input**: `gain = [-4,-3,-2,-1,4,3,2]`
- **Output**: `0`
- **Explanation**: The altitudes are `[0,-4,-7,-9,-10,-6,-3,-1]`. The highest is `0`.

### Constraints
- n == gain.length
- 1 <= n <= 100
- -100 <= gain[i] <= 100

### Topics
- Array
- Prefix Sum

### Hints
1. Let's note that the altitude of an element is the sum of gains of all the elements behind it.
2. Getting the altitudes can be done by getting the prefix sum array of the given array.

LeetCode Problem URL

## Solution

```java

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