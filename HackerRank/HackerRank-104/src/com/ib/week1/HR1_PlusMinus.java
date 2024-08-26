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

class Result {

	/*
	 * Complete the 'plusMinus' function below.
	 *
	 * The function accepts INTEGER_ARRAY arr as parameter.
	 */

	public static void plusMinus(List<Integer> arr) {
		double n = arr.size();
//		System.out.println("n"+n);
		double pos = 0, neg = 0, zero = 0;
		for (Integer i : arr) {
//			System.out.println(i);
			if (i == 0) {
				zero++;
			} else if (i > 0) {
				pos++;
			} else {
				neg++;
			}
		}

		double div1 = pos / n;
		double div2 = neg / n;
		double div3 = zero / n;

		System.out.printf("%.6f%n", div1);
		System.out.printf("%.6f%n", div2);
		System.out.printf("%.6f%n", div3);

	}

}

public class HR1_PlusMinus {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(bufferedReader.readLine().trim());

//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(-1);
		arr.add(-3);
		arr.add(0);
		Result.plusMinus(arr);
		bufferedReader.close();
	}
}
