package com.ib.p05_hashmapset;

import java.util.*;

public class LP20_2215_DiffTwoArrays {

	public static void main(String[] args) {
		new Solution20().findDifference(new int[] { 1, 2, 3 }, new int[] { 2, 4, 6 });

	}

}

class Solution20 {

	/**
	 * Approach here::
	 * We Need: all distinct integers in nums1 which are not present in nums2
	 * 			all distinct integers in nums2 which are not present in nums1
	 * :: First We get all distinct element in num1 & num2:
	 * 		Create SET with the array num1 & num2(SET auto stores only distinct elements)
	 * ::	Append into list1 if the element is not in set2
	 * 		Append into list2 if the element is not in set1
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		for (Integer integer : nums1) {
			set1.add(integer);
		}
		
		Set<Integer> set2 = new HashSet<Integer>();
		for (Integer integer : nums2) {
			set2.add(integer);
		}
//		System.out.println(set1.toString());
//		System.out.println(set2.toString());

		List<Integer> list1 = new ArrayList<Integer>();
		for (Integer integer : set1) {
			if (!set2.contains(integer)) {
				list1.add(integer);
			}
		}
		
		List<Integer> list2 = new ArrayList<Integer>();
		for (Integer integer : set2) {
			if (!set1.contains(integer)) {
				list2.add(integer);
			}
		}
//		System.out.println(list1.toString());
//		System.out.println(list2.toString());

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		output.add(list1);
		output.add(list2);
		return output;
	}

	/**
	 * Approach here::
	 * We Need: all distinct integers in nums1 which are not present in nums2
	 * 			all distinct integers in nums2 which are not present in nums1
	 * :: First We find all distinct element in num1 & num2:
	 * 		Create SET with the array num1 & num2(SET auto stores only distinct elements)
	 * :: Second we need to eliminate element which are common in both num1 & num2
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		for (Integer integer : nums1) {
			set1.add(integer);
		}
		for (Integer integer : nums2) {
			set2.add(integer);
		}
		System.out.println(set1.toString());
		System.out.println(set2.toString());

		List<Integer> list1 = new ArrayList<Integer>(set1);
		List<Integer> list2 = new ArrayList<Integer>(set2);
		for (Integer integer : set1) {
			if (set2.contains(integer)) {
				list1.remove(integer);
				list2.remove(integer);
			}
		}
		System.out.println(list1.toString());
		System.out.println(list2.toString());

		List<List<Integer>> output = new ArrayList<List<Integer>>();
		output.add(list1);
		output.add(list2);
		return output;
	}
}