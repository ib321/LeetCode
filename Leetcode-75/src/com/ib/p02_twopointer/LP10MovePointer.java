package com.ib.p02_twopointer;

import java.util.Arrays;

public class LP10MovePointer {

	public static void main(String[] args) {
		new Solution10().moveZeroes3(new int[] { 0, 1, 0, 3, 12 });

	}

}

class Solution10 {

	/*-Tip check out 2nd method cute isn't it...
	 *Approach:
	 * 	Aim is to put all the zero of given array to last
	 * 
	 *Two  Array Approach: 
	 *	initialize another array with same length;
	 *	loop input array use whenever non zero element put into new array into consecutive order
	 *	use a index pointer to maintain the order
	 *	now loop again this time just replace all the element with zero that are non zero.
	 */
	public void moveZeroes3(int[] nums) {
		int[] arr2 = new int[nums.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				arr2[index++] = nums[i];
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			if (!(arr2[i] != 0))
				arr2[i] = 0;
		}

		System.out.println(Arrays.toString(arr2));
	}

	/*-
	 * Approach:
	 * 	Aim is to put all the zero of given array to last
	 * 	Optimization : 
	 * 		we can use same array for the above operartion
	 * 		we can start second loop from index pointer to last length
	 * @param nums : integer array 
	 */
	public void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0)
				nums[index++] = nums[i];
		}

		for (int i = index; i < nums.length; i++) {
			nums[i] = 0;
		}
		// System.out.println(Arrays.toString(nums));
	}

	/*-
	 * Ignnore this if you still want it ok go ahead.. :)
	 */
	public void moveZeroes2(int[] nums) {
		int index = 0;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				nums[index++] = nums[i];
			}
		}

		for (int i = nums.length - 1; i >= 0; i--) {
			if (count == 0)
				break;
			nums[i] = 0;
			count--;
		}
		// System.out.println(Arrays.toString(nums));
	}

}