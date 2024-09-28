```java
package com.ib.learn.p01_basic.t1_math;

public class LP7_PrimeNumber {

	public static void main(String[] args) {
		System.out.println(SolutionLP07.checkPrime(7));
		
		int start = 0; // Starting range
        int end = 50;   // Ending range
        for (int i = start; i <= end; i++) {
            if (SolutionLP07.checkPrime(i)) {
                System.out.println(i + " is a prime number.");
            }
        }
	}
}

class SolutionLP07 {
	/**
	 * A prime number is a number that is only divisible by 1 and itself.
	 * 2 is also prime :: only even prime number it's also divided by 1 and itself
	 * 
	 * @param n the number to check
	 * @return true if n is a prime number, false otherwise
	 */
	static boolean checkPrime(int n) {
		if (n <= 1) {
			return false;
		}
		// starts from 2 so as soon as it gets divided by any number we return false
		// upto sqrt of n cause checking for greater then sqrt doesn't divide number other then itself
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				// inside this mean number has been divided by any number other then 1 & itself
				return false;
			}
		}
		return true;
	}
	
	// Not efficient method
	static boolean checkPrime2(int n) {
		// primes are positive number
		if (n <= 1) {
			return false;
		}
		
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				count++;
		}

		if (count == 2)
			return true;
		else
			return false;
	}
}
