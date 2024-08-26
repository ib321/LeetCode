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

class Result3 {

	/*
	 * Complete the 'timeConversion' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */

	public static String timeConversion(String s) {
		String sdate = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ssa");
			Date date = sdf.parse(s);
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
			// System.out.println(date);
			sdate = sdf2.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sdate;

	}

}

public class HR3_TimeConversion {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = "07:05:45PM";// bufferedReader.readLine();

		String result;
		result = Result3.timeConversion(s);
		System.out.println(result);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();

		bufferedReader.close();
//        bufferedWriter.close();
	}
}
