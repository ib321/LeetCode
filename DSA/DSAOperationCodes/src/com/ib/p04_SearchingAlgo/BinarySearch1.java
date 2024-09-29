package com.ib.p04_SearchingAlgo;

//Java implementation of iterative Binary Search
public class BinarySearch1 {

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 40;
		int result = new BinarySearch().binarySearch2(arr, x);
		if (result == -1)
			System.out.println("Element is not present in array");
		else
			System.out.println("Element is present at " + "index " + result);
	}
}

class BinarySearch {

	int binarySearch(int arr[], int key) {
		int lowindex = 0, highindex = arr.length - 1;
		while (lowindex <= highindex) {
			//(a + b) / 2 = a + (b - a) / 2
			//int mid = lowindex + (highindex - lowindex) / 2;
			int mid = (lowindex + highindex) / 2;
			// if x is present at mid return index
			if (arr[mid] == key)
				return mid;

			// If x greater, ignore left half
			if (arr[mid] < key)
				lowindex = mid + 1;

			// If x is smaller, ignore right half
			else
				highindex = mid - 1;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param arr : sorted array,
	 * @param key : element to find in arr
	 * @return index of key in arr if not found return -1
	 */
	int binarySearch2(int arr[], int key) {
		int low = 0; int high = arr.length -1;
		while(low<=high) {
			// find mid node
			int mid = (low+high)/2;
			// if element found at mid return index
			if(key==arr[mid])
				return mid;
			// key greater then mid i.e key is in right side
			// keep high at last index 
			// move low pointer mid se 1 aage ( cuts off left side elements)
			if(key > arr[mid])
				low = mid+1;
			// key less then mid i.e key is in left side so
			// keep low at start index
			// move high pointer mid se 1 piche ( cuts off right side elements)
			if(key<arr[mid])
				high =mid-1;
		}
		return -1;
	}
	
	
}

