# 605. Can Place Flowers

**Difficulty**: Easy

## Problem Statement
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots. Given an integer array `flowerbed` containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer `n`, return `true` if `n` new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and `false` otherwise.

### Examples

**Example 1:**
- **Input**: `flowerbed = [1,0,0,0,1]`, `n = 1`
- **Output**: `true`

**Example 2:**
- **Input**: `flowerbed = [1,0,0,0,1]`, `n = 2`
- **Output**: `false`

### Constraints
	• 1 <= flowerbed.length <= 2 * 104
	• flowerbed[i] is 0 or 1.
	• There are no two adjacent flowers in flowerbed.
	• 0 <= n <= flowerbed.length

## Solution

```java

package com.ib.arraystring;

public class LP4CanPlaceFlower {

	public static void main(String[] args) {
		int[] n = { 0, 0, 0, 0, 0 };

		System.out.println(new Solution4().canPlaceFlowers(n, 2));

	}

}

class Solution4 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int maxflowercanbeplated = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {
				boolean prevEmpty = (i == 0) || flowerbed[i - 1] == 0;
				boolean nextEmpty = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;
				if (prevEmpty && nextEmpty) {
					++maxflowercanbeplated;
					flowerbed[i] = 1;
				}
			}
		}

		return n <= maxflowercanbeplated;
	}
}
