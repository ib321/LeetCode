package com.ib.p05_hashmapset;

import java.util.Arrays;
import java.util.*;

public class LP23_2353_EqualRowColumnPairs {

	public static void main(String[] args) {
		System.out.println(new Solution23().equalPairs(new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } }));

	}

}

class Solution23 {
	
	/**
	 * Goal is to find how many rows and column are equals
	 * 
	 * Approach::
	 * 1. created a HashMap to store toString output value of the rows & their occurrence.
	 * 2. In next loop creating the column from given grid.
	 * 		then look for those created column int[] toString format into prev. hashmap
	 * 		if they are found that mean we found the equal column increase the count.
	 * @param grid
	 * @return
	 */
	public int equalPairs(int[][] grid) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		// Storing row toString & their occurrence count in map
		for (int[] row : grid) {
			String key = Arrays.toString(row);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		System.out.println(map.toString());

		int count = 0;
		int length = grid.length;
		for (int i = 0; i < length; i++) {
			int[] column = new int[length];
			for (int j = 0; j < length; j++) {
				column[j] = grid[j][i];
			}
			// why aren't we just increasing the count as if there are 
			// two same rows then one column will be 2 times equal so better sum the occurrences.
			count += map.getOrDefault(Arrays.toString(column), 0);
		}
		return count;
	}
}