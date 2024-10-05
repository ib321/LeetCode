package com.ib.p04_SortingAlgo;

import java.util.Arrays;

public class P02_SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 2 };
		selectionSort(arr);
		System.out.println("Sorted array is: " + Arrays.toString(arr));
	}

	/*-
	 * Steps of the Selection Sort Algorithm:
	 * 	Start with the first element as the initial position.
	 * 	Find the smallest element in the unsorted portion of the array.
	 * 	Swap this smallest element with the first unsorted element.
	 * 	Move the boundary of the sorted portion one element forward.
	 * 	Repeat steps 2-4 for the remaining unsorted elements until the entire array is sorted.
	 * 
	 * @param arr
	 */
	static void selectionSort(int arr[]) {
		int n = arr.length;

		// traverse the array
		for (int i = 0; i < n - 1; i++) {

			// assume smallest is first index element
			int min_ind = i;

			// move boundary to i+1 go till n
			// compare every other left in unsorted element with min_ind
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_ind]) {
					min_ind = j;
				}
			}

			// check if assumed min ind is same or diff
			// if diff then swap them
			if (min_ind != i) {
				int temp = arr[i];
				arr[i] = arr[min_ind];
				arr[min_ind] = temp;
			}

		}
	}
}
