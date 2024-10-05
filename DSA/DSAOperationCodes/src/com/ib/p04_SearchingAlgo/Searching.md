### Linear Search Algorithm:
Sequential search algorithm that starts at one end and goes through each element of a list until the desired element is found; otherwise, the search continues till the end of the dataset.

#### Example:
arr[] = {10, 50, 30, 70, 80, 20, 90, 40} 
key = 30

- Traverse the Array
- Compare each element with the key if it matches return the index
- If not then no match found

## Java Code:

```java
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

// Java code for linearly searching in array 
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

```

**Time Complexity:** \(O(N)\)

#### Applications of Linear Search Algorithm:
- Unsorted Lists: It is most commonly used to find any element in unsorted array or list.
- Small Data Sets: Linear Search is preferred over binary search when we have small data sets with.
- Searching Linked Lists: In linked list implementations, linear search is commonly used to find elements within the list. Each node is checked sequentially until the desired element is found.
- Simple Implementation: Linear Search is much easier to understand and implement as compared to Binary Search or Ternary Search.

#### Advantages of Linear Search Algorithm:
- It doesn't require any preprocessing like sorting suitable for dynamic database.
- Linear search can be used irrespective of whether the array is sorted or not. It can be used on arrays of any data type.
- Does not require any additional memory.
- It is a well-suited algorithm for small datasets.

#### Disadvantages of Linear Search Algorithm:
- Linear search has a time complexity of \(O(N)\), which in turn makes it slow for large datasets.
- Not suitable for large arrays.

#### When to use Linear Search Algorithm?
- When we are dealing with a small dataset.
- When you are searching for a dataset stored in contiguous memory.
- While linear search algorithm can still be used on sorted arrays or lists, it’s not the most efficient option. Binary search, for example, is more suitable for sorted data as it has a time complexity of \(O(\log n)\).



### Binary Search Algorithm:
This searching algorithm is used in a sorted array by repeatedly dividing the search interval in half.
The idea of binary search is to use the information that the array is sorted and reduce the time complexity to \(O(\log N)\).

Binary search is a search algorithm used to find the position of a target value within a sorted array.
It works by repeatedly dividing the search interval in half until the target value is found or the interval is empty.
The search interval is halved by comparing the target element with the middle value of the search space.

#### Conditions to Apply Binary Search Algorithm in a Data Structure:
- The data structure must be sorted.
- Access to any element of the data structure should take constant time.

#### Binary Search Algorithm:
Below is the step-by-step algorithm for Binary Search:
- Divide the search space into two halves by finding the middle index “mid”.
- Compare the middle element of the search space with the key.
- If the key is found at the middle element, the process is terminated.
- If the key is not found at the middle element, choose which half will be used as the next search space.
  - If the key is smaller than the middle element, then the left side is used for the next search.
  - If the key is larger than the middle element, then the right side is used for the next search.
- This process is continued until the key is found or the total search space is exhausted.

#### Iterative Binary Search Algorithm:
## Java

```java
package com.ib.p04_SearchingAlgo;

//Java implementation of iterative Binary Search
public class BinarySearch1 {

	public static void main(String args[]) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 40;
		int result = new BinarySearch().binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element is not present in array");
		else
			System.out.println("Element is present at " + "index " + result);
	}
}

class BinarySearch {

	/**
	 * 
	 * @param arr : sorted array,
	 * @param key : element to find in arr
	 * @return index of key in arr if not found return -1
	 */
	int binarySearch(int arr[], int key) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			// find mid node
			// (a + b) / 2 = a + (b - a) / 2
			// int mid = lowindex + (highindex - lowindex) / 2;
			int mid = (low + high) / 2;
			// if element found at mid return index
			if (key == arr[mid])
				return mid;
			// key greater then mid i.e key is in right side
			// keep high at last index
			// move low pointer mid se 1 aage ( cuts off left side elements)
			if (key > arr[mid])
				low = mid + 1;
			// key less then mid i.e key is in left side so
			// keep low at start index
			// move high pointer mid se 1 piche ( cuts off right side elements)
			if (key < arr[mid])
				high = mid - 1;
		}
		return -1;
	}

}


```
#### Recursive Binary Search Algorithm:
## Java

```java
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


```

#### Advantages of Binary Search:
- Binary search is faster than linear search, especially for large arrays.
- More efficient than other searching algorithms with a similar time complexity, such as interpolation search or exponential search.
- Binary search is well-suited for searching large datasets that are stored in external memory, such as on a hard drive or in the cloud.
- Can also be used for non-numeric data as long as there is a defined order of data (e.g., strings in alphabetical order).

#### Disadvantages of Binary Search:
- The array should be sorted in ascending or descending order. If the array is not sorted, we cannot use Binary Search.
- Binary search requires that the data structure being searched be stored in contiguous memory locations.
- Binary search requires that the elements of the array be comparable, meaning that they must be able to be ordered.

#### Applications of Binary Search Algorithm:
- It can be used for searching a database.
- Binary search can be used as a building block for more complex algorithms used in machine learning, like algorithms for training neural networks or finding the optimal hyperparameters for a model.
- It can be used for searching in computer graphics such as algorithms for ray tracing or texture mapping.

