package com.ib.p04_SearchingAlgo;

//Java implementation of recursive Binary Search
public class BinarySearch2 {

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int n = arr.length;
		int x = 10;
		int result = new BinarySearchRec().binarySearch(arr, 0, n - 1, x);
		if (result == -1)
			System.out.println("Element is not present in array");
		else
			System.out.println("Element is present at index " + result);
	}
}

class BinarySearchRec {

	int binarySearch(int arr[], int low, int high, int key2find) {
		if (high >= low) {
			// int mid = low + (high - low) / 2;
			int mid = (low + high) / 2;

			if (arr[mid] == key2find)
				return mid;

			if (key2find < arr[mid])
				return binarySearch(arr, low, mid - 1, key2find);

			return binarySearch(arr, mid + 1, high, key2find);
		}
		return -1;
	}
}
