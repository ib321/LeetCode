# 2352. Equal Row and Column Pairs

**Difficulty**: Medium

## Problem Statement
Given a 0-indexed `n x n` integer matrix `grid`, return the number of pairs `(r_i, c_j)` such that row `r_i` and column `c_j` are equal. A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

### Examples

**Example 1:**
- **Input**: `grid = [[3,2,1],[1,7,6],[2,7,7]]`
- **Output**: `1`
- **Explanation**: There is 1 equal row and column pair:
  - (Row 2, Column 1): `[2,7,7]`

**Example 2:**
- **Input**: `grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]`
- **Output**: `3`
- **Explanation**: There are 3 equal row and column pairs:
  - (Row 0, Column 0): `[3,1,2,2]`
  - (Row 2, Column 2): `[2,4,2,2]`
  - (Row 3, Column 2): `[2,4,2,2]`

### Constraints
- `n == grid.length == grid[i].length`
- `1 <= n <= 200`
- `1 <= grid[i][j] <= 105`

### Topics
- Array
- Hash Table
- Matrix
- Simulation

### Hints
1. We can use nested loops to compare every row against every column.
2. Another loop is necessary to compare the row and column element by element.
3. It is also possible to hash the arrays and compare the hashed values instead.

[LeetCode Problem URL](https://leetcode.com/problems/equal-row-and-column-pairs/description/)

## Solution

```java

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