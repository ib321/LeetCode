# 283. Move Zeroes

**Difficulty**: Easy

## Problem Statement
Given an integer array `nums`, move all 0's to the end of it while maintaining the relative order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

### Examples

**Example 1:**
- **Input**: `nums = [0,1,0,3,12]`
- **Output**: `[1,3,12,0,0]`

**Example 2:**
- **Input**: `nums = [0]`
- **Output**: `[0]`

### Constraints
- 1 <= nums.length <= 104
- -231 <= nums[i] <= 231 - 1

### Follow-up
Could you minimize the total number of operations done?

[LeetCode Problem URL](https://leetcode.com/problems/move-zeroes/)

## Solution

```java

package com.ib.p02_twopointer;

import java.util.Arrays;

public class LP10MovePointer {

	public static void main(String[] args) {
		new Solution10().moveZeroes(new int[] {0,1,0,3,12});

	}

}

class Solution10 {
	
	 public void moveZeroes(int[] nums) {
	        int index = 0;
	        for (int i = 0; i < nums.length; i++) {
				if(nums[i] != 0)
				{
					nums[index++]  = nums[i];
				}
			}
	        
	        for(int i=index;i<nums.length;i++)
	        {
	        	nums[i] = 0;
	        }
	        //System.out.println(Arrays.toString(nums));
	    }
	 
	 
    public void moveZeroes2(int[] nums) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
			{
				count++;
			}
			else
			{
				nums[index++]  = nums[i];
			}
		}
        
        for(int i=nums.length-1;i>=0;i--)
        {
        	if(count == 0)
        		break;
        	nums[i] = 0;
        	count--;
        }
        //System.out.println(Arrays.toString(nums));
    }
    
   
}