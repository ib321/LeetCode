package com.ib.p04_SearchingAlgo;

public class LinearSearch {
	public static void main(String args[]) {

		int arr[] = { 2, 3, 4, 10, 40 };
		int keytofind = 10;

		int result = SolutionLS01.search(arr, keytofind);
		if (result == -1)
			System.out.print("Element not found");
		else
			System.out.print("Element Found at " + result);
	}
}

//Java code for linearly searching in array 
class SolutionLS01 {
	/**
	 * 
	 * @param arr       : array to find the key in
	 * @param keytofind : key to be found in the array
	 * @return return the index of found array if not found returns -1;
	 */
	static int search(int arr[], int keytofind) {
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			if (arr[i] == keytofind)
				return i;
		}
		return -1;
	}
}
