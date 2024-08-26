package com.ib.week1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result2 {

	/*
	 * Complete the 'miniMaxSum' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void miniMaxSum(List<Integer> arr) {

		long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;

		long sum = 0;
		long n = arr.size();
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				sum = sum + arr.get(j);

			}
			// System.out.println(sum);
			if (sum > min)
				min = sum;
			if (sum < max)
				max = sum;
		}
		System.out.print(max + " " + min);

	}

}

public class HR2_MiniMaxSum {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//      int n = Integer.parseInt(bufferedReader.readLine().trim());

//      List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//          .map(Integer::parseInt)
//          .collect(toList());
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(4);
		arr.add(9);
		arr.add(6);
		arr.add(5);
		Result2.miniMaxSum(arr);
		bufferedReader.close();
	}
}
