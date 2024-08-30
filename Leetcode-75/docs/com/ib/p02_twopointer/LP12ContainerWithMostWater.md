# 11. Container With Most Water

**Difficulty**: Medium

## Problem Statement
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`th line are `(i, 0)` and `(i, height[i])`. Find two lines that together with the x-axis form a container, such that the container contains the most water. Return the maximum amount of water a container can store. Notice that you may not slant the container.

### Examples

**Example 1:**
- **Input**: `height = [1,8,6,2,5,4,8,3,7]`
- **Output**: `49`
- **Explanation**: The above vertical lines are represented by array `[1,8,6,2,5,4,8,3,7]`. In this case, the max area of water (blue section) the container can contain is 49.

!Container With Most Water

**Example 2:**
- **Input**: `height = [1,1]`
- **Output**: `1`

### Constraints
- `n == height.length`
- `2 <= n <= 105`
- `0 <= height[i] <= 104`

[LeetCode Problem URL](https://leetcode.com/problems/container-with-most-water/)

## Solution

```java

package com.ib.p02_twopointer;

public class LP12ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(new Solution12().maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

	}
}

class Solution12 {
	
	//Two Pointer solution : O(n)
		public int maxArea(int[] height) {
			int maxArea = 0;
			int totalLength = height.length;
			int left = 0;
			int right = totalLength -1;
			
			while(left < right)
			{
				int chosenHeightLeft = height[left];
				int chosenHeightRight = height[right];
				int minHeight = Math.min(chosenHeightLeft, chosenHeightRight);

				int length = right - left;
				int Area = minHeight * length;
				if (Area > maxArea)
					maxArea = Area;
				
				//Pointer Movement Logic: Always choosing max height
				//bw these max length of left n right
				if(chosenHeightLeft<chosenHeightRight)
					left++;
				else
					right--;
			}

			return maxArea;
		}

	//Brute Force : O(n^2)
	public int maxArea2(int[] height) {
		int maxArea = 0;
		int totalLength = height.length;
		for (int i = 0; i < totalLength; i++) {
			for (int j = totalLength - 1; j >= 0; j--) {
				int chosenHeightA = height[i];
				int chosenHeightB = height[j];
				int minheight = chosenHeightA;
				if (chosenHeightB < minheight)
					minheight = chosenHeightB;
				int length = j - i;
				int Area = minheight * length;
				if (Area > maxArea)
					maxArea = Area;
			}
		}
		return maxArea;
	}
}
