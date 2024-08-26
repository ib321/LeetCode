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

class Result4 {

	/*
	 * Complete the 'breakingRecords' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY scores as parameter.
	 */

	public static List<Integer> breakingRecords(List<Integer> scores) {

		int[] storeArr = { 0, 0 };
		int max = scores.get(0);
		int min = scores.get(0);
		int j = 0, k = 0;
		;
		for (int i = 0; i < scores.size(); i++) {

//			System.out.println(scores.get(i));

			if (scores.get(i) > max) {
				max = scores.get(i);
				storeArr[0] = ++j;
			} else if (scores.get(i) < min) {
				min = scores.get(i);
				storeArr[1] = ++k;
			}
		}
		List<Integer> out = new ArrayList<Integer>();
		for (int in : storeArr) {
			System.out.println(in);
			out.add(in);
		}
		return out;
	}

}

public class HR4_BreakingTheRecord {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
		List<Integer> scores = new ArrayList<>();
		scores.add(10);
		scores.add(5);
		scores.add(20);
		scores.add(20);
		scores.add(4);
		scores.add(5);
		scores.add(2);
		scores.add(25);
		scores.add(1);

		List<Integer> result = Result4.breakingRecords(scores);

		for (Integer integer : result) {
			System.out.println(integer);
		}
//        bufferedWriter.write(
//            result.stream()
//                .map(Object::toString)
//                .collect(joining(" "))
//            + "\n"
//        );

		bufferedReader.close();
		// bufferedWriter.close();
	}
}
