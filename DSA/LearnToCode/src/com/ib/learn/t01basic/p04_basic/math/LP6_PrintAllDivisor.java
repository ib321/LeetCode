package com.ib.learn.t01basic.p04_basic.math;

import java.util.ArrayList;

public class LP6_PrintAllDivisor {

	public static void main(String[] args) {
		int n = 36;
		int[] divs = SolutionLP06.printDivisors(n);
		for (int i = 0; i < divs[n]; i++) {
			System.out.println(divs[i]);
		}
		ArrayList<Integer> divarr = SolutionLP06.printDivisors2(40);
		for (Integer integer : divarr) {
			System.out.println(integer);
		}
	}
}

class SolutionLP06 {
	/**
	 * print all divisor of a number Input:N = 36 Output:[1, 2, 3, 4, 6, 9, 12, 18,
	 * 36]
	 * 
	 * @param num
	 * @return
	 */
	public static int[] printDivisors(int n) {

		int[] divs = new int[1+n];
		int count = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				divs[count++] = i;
			}
		}
		// storing size of this divs to n+1 location
		divs[n] = count;

		return divs;

	}
	
	// optimized way 
	public static ArrayList<Integer> printDivisors2(int n) {
		ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        // Sorting the list to maintain order
        divisors.sort(Integer::compareTo);
        return divisors;
    }
}