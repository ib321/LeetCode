### Sorting in DSA
- Process of arranging a collection of data elements in a specific order, usually in ascending or descending order.

##### Characteristics of Sorting:
1. **Time Complexity:**
	- Time complexity, a measure of how long it takes to run an algorithm.
	- It is used to categorize sorting algorithms.
2. **Space Complexity:**
	- Space complexity, amount of memory required to execute algorithm.
3. **Stability:**
	- If the relative order of equal elements is preserved after sorting, then a sorting algorithm is said to be stable.
4. **In-Place Sorting Algo:**
	- Algo that does not require additional memory to sort the data.
	- Important when the available memory is limited or when the data cannot be moved.
5. **Adaptivity Algo:**
	- Algo that takes advantage of pre-existing order in the data to improve performance.

##### Stability of Sorting:
- **Stable Sorting Algorithm**
- **Unstable Sorting Algorithm**
- The relative order of equal elements is preserved by stable sorting algorithms but is not ensured by unstable sorting algorithms.

##### Applications of Sorting:
- Searching and retrieval of data
- Data analysis and visualization
- Database management and optimization
- Sorting and organizing files and directories
- Image and signal processing

##### Advantages of Sorting:
- **Improved Search Efficiency:**
  - It helps to organize data in a way that improves search efficiency.
- **Better Data Analysis:**
  - Help in data analysis by identifying patterns, outliers, and trends.
  - And to summarize large datasets by grouping similar items together.
- **Easier Data Management:**
  - It can also make it easier to manage data by organizing it in a way that is easy to understand and work with.

##### Disadvantages of Sorting in DSA:
- Can be computationally expensive, especially for large datasets.
- This may require additional memory to perform the sorting operation.
- Maintaining the sort order of data can add complexity to data updates and insertions, which can be a disadvantage when dealing with dynamic datasets.

### Bubble Sort Algo:
- It is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.

##### Advantages of Bubble Sort:
- Bubble sort is easy to understand and implement.
- It does not require any additional memory space.
- It is a stable sorting algorithm, meaning that elements with the same key value maintain their relative order in the sorted output.

##### Disadvantages of Bubble Sort:
- Bubble sort has a time complexity of \(O(n^2)\) which makes it very slow for large data sets.
- Bubble sort is a comparison-based sorting algorithm, meaning it requires a comparison operator to determine the relative order of elements in the input data set.

**Time Complexity:** \(O(n^2)\)

**Auxiliary Space:** \(O(1)\)

```java
package com.ib.p04_SortingAlgo;

import java.util.Arrays;

/*-
Basically ham bas 2 consecutive element ko sort krte krte bada element ko last ki or le jate h 
After one outer loop execution(inner executes for total-outer-1) sabse bada element last tak jata rehta hai.
With each outer loop 1 last element is sorted so inner loop loops starts reducing 
 */
public class BubbleSort {

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
```

### Selection Sort Algo:
- Comparison-based sorting algorithm.
- It sorts an array by repeatedly selecting the smallest (or largest) element from the unsorted portion and swapping it with the first unsorted element. This process continues until the entire array is sorted.

##### Advantages of Bubble Sort:
- It is easy to understand and implement.
- It does not require any additional memory space.

##### Disadvantages of Bubble Sort:
- It has a time complexity of \(O(n^2)\) which makes it very slow for large data sets.
- Does not maintain the relative order of equal elements means it is not stable.

**Time Complexity:** \(O(n^2)\)

**Auxiliary Space:** \(O(1)\)

```java
package com.ib.p04_SortingAlgo;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 4, 2 };
        selectionSort(arr);
        System.out.println("Sorted array is: " + Arrays.toString(arr));
    }

    /*-
     * Steps of the Selection Sort Algorithm:
     *  Start with the first element as the initial position.
     *  Find the smallest element in the unsorted portion of the array.
     *  Swap this smallest element with the first unsorted element.
     *  Move the boundary of the sorted portion one element forward.
     *  Repeat steps 2-4 for the remaining unsorted elements until the entire array is sorted.
     * 
     * @param arr
     */
    static void selectionSort(int arr[]) {
        int n = arr.length;

        // traverse the array
        for (int i = 0; n - 1; i++) {

            // assume smallest is first index element
            int min_ind = i;

            // move boundary to i+1 go till n
            // compare every other left in unsorted element with min_ind
            for (int j = i + 1; n; j++) {
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
```
