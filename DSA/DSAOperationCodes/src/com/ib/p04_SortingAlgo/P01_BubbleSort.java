package com.ib.p04_SortingAlgo;

import java.util.Arrays;

/*-
Basically ham bas 2 consecutive element ko sort krte krte bada element ko last ki or le jate h 
After one outer loop execution(inner executes for total-outer-1) sabse bada element last tak jata rehta hai.
With each outer loop 1 last element is sorted so inner loop loops starts reducing 
 */
public class P01_BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 5, 3, 8, 4, 2 };
		bubbleSort(arr);
		System.out.println("Sorted array is: " + Arrays.toString(arr));
	}

	/*-
	 * In Outer loop we iterate the array.
	 * In Inner loop we compare two consecutive element 
	 * 	and swap if they are in wrong order
	 * For each outer loop execution inner loop executes for outer total -1 times
	 * It gets reduced by 1 time cause each time the biggest element get moved to last of array
	 * 
	 * @param arr
	 */
	static void bubbleSort(int arr[]) {
		int n = arr.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {

					// Swap arr[j] and arr[j+1]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// If no two elements were swapped by inner loop, then break
			// this flag save the time in case of already sorted array
			// by saving time by not comparing in above case
			if (swapped == false)
				break;
		}
	}
}
