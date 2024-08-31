# 1207. Unique Number of Occurrences

**Difficulty**: Easy

## Problem Statement
Given an array of integers `arr`, return true if the number of occurrences of each value in the array is unique or false otherwise.

### Examples

**Example 1:**
- **Input**: `arr = [1,2,2,1,1,3]`
- **Output**: `true`
- **Explanation**: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

**Example 2:**
- **Input**: `arr = [1,2]`
- **Output**: `false`

**Example 3:**
- **Input**: `arr = [-3,0,1,-3,1,1,1,-3,10,0]`
- **Output**: `true`

### Constraints
- 1 <= arr.length <= 1000
- -1000 <= arr[i] <= 1000

### Topics
- Array
- Hash Table

### Hints
1. Find the number of occurrences of each element in the array using a hash map.
2. Iterate through the hash map and check if there is a repeated value.

[LeetCode Problem URL](https://leetcode.com/problems/unique-number-of-occurrences/)

## Solution

```java

package com.ib.p05_hashmapset;

import java.util.*;

public class LP21_1207_UniqueOccurance {

	public static void main(String[] args) {
		System.out.println(new Solution21().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));

	}
}

class Solution21 {
	
	/**
	 * Goal is to find number of occurrences of each value in the array is unique;
	 * Approach:
	 * 1. Find the Occurrence of each value in array
	 * 		Using Map we can store key and value and update occurrence.
	 * 2. Now we need to find if those map values are unique
	 * 		Add all map values to a ArrayList: create a set out of that List
	 * 		Now If it was unique length of Array list & Set will be same.
	 * @param arr
	 * @return
	 */
	public boolean uniqueOccurrences2(int[] arr) {

		Map<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if(!occuranceMap.containsKey(i))
				occuranceMap.put(i, 1);
			else
			occuranceMap.put(i, occuranceMap.get(i) + 1);
		}
		
		ArrayList<Integer> listOfOccurance = new ArrayList<Integer>();
		for (Integer val : occuranceMap.values()) {
			listOfOccurance.add(val);
		}
//		Another way to iterate the Map
//		for (Map.Entry<Integer, Integer> entry : occuranceMap.entrySet()) {
//			listOfOccurance.add(entry.getValue());
//		}
		Set<Integer> setOfOccurance = new HashSet<Integer>(listOfOccurance);

//		System.out.println(occuranceMap.toString());
//		System.out.println(listOfOccurance);
//		System.out.println(setOfOccurance);

		return listOfOccurance.size() == setOfOccurance.size();
	}

	/**
	 * Goal is to find number of occurrences of each value in the array is unique;
	 * Approach:
	 * 1. Find the Occurrence of each value in array
	 * 		Using Map we can store key and value and update occurrence.
	 * 2. Now we need to find if those map values are unique
	 * 		Add all map values to a Set when we call .add on Set it return false if value already exist
	 * 		So if add return false that mean occurrence wasn't unique otherwise unique
	 * @param arr
	 * @return
	 */
	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> occuranceMap = new HashMap<Integer, Integer>();
		for (int i : arr) {
			if(!occuranceMap.containsKey(i))
				occuranceMap.put(i, 1);
			else
			occuranceMap.put(i, occuranceMap.get(i) + 1);
		}
		
		Set<Integer> setOfOccurance = new HashSet<Integer>();
		for (Integer val : occuranceMap.values()) {
			//If this return false mean occurrence not unique return false then
			if(!setOfOccurance.add(val)) 
				return false;
		}
		
//		System.out.println(occuranceMap.toString());
//		System.out.println(setOfOccurance);
		return true;
	}
}
