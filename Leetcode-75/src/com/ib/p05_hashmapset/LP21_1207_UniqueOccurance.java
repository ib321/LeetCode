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
