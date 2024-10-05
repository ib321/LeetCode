package com.ib.p04_SortingAlgo;

public class P04_MergeSort {

	// Merges two subarrays of arr[].
	private void merge(int arr[], int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		// Create temporary arrays
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];

		// Copy data to temp arrays
		for (int i = 0; i < n1; ++i)
			leftArray[i] = arr[left + i];
		for (int j = 0; j < n2; ++j)
			rightArray[j] = arr[mid + 1 + j];

		// Merge the temp arrays
		int i = 0, j = 0;

		// Initial index of merged subarray
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			} else {
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of leftArray[], if any
		while (i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}

		// Copy remaining elements of rightArray[], if any
		while (j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[left...right] using merge()
	public void sort(int arr[], int left, int right) {
		if (left < right) {
			// Find the middle point
			int mid = (left + right) / 2;

			// Sort first and second halves
			sort(arr, left, mid);
			sort(arr, mid + 1, right);

			// Merge the sorted halves
			merge(arr, left, mid, right);
		}
	}

	public static void main(String args[]) {
		int arr[] = { 38, 27, 43, 3, 9, 82, 10 };

		P04_MergeSort ob = new P04_MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("Sorted array: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
