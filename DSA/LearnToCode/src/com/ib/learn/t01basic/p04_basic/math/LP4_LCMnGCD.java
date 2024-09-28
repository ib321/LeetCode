package com.ib.learn.t01basic.p04_basic.math;

public class LP4_LCMnGCD {

	public static void main(String[] args) {
		Long[] result1 = SolutionLP04.lcmAndGcd2(5L, 10L);
		System.out.println("LCM: " + result1[0] + ", GCD: " + result1[1]);

		new SolutionLP04();
		Long[] result2 = SolutionLP04.lcmAndGcd2(14L, 8L);
		System.out.println("LCM: " + result2[0] + ", GCD: " + result2[1]);
	}
}

class SolutionLP04 {

	// optimized way
	static Long[] lcmAndGcd2(Long A, Long B) {
		long tA = A;
		long tB = B;
		// finding GCD:
		// dividing bigger number with reminder when that number is 0 last no is gcd.
		while (B != 0) {
			long temp = B; // Store B in a temporary variable
			B = A % B; // Update B to the remainder of A divided by B
			A = temp; // Update A to the value of B
		}
		long gcd = A;
		// finding LCM: formula is lcm(a.b) * gcd(a,b) = a*b
		long lcm = tA * tB / gcd;

		return new Long[] { lcm, gcd };

	}

	// brute force way
	static Long[] lcmAndGcd(Long A, Long B) {
		long min = A;
		long max = B;
		if (B < A) {
			min = B;
			max = A;
		}
		long gcd = 1;
		// finding GCD:
		for (int i = 2; i <= min; i++) {
			if (A % i == 0 && B % i == 0) {
				gcd = i;
				break;
			}
		}
		// finding LCM: formula is lcm(a.b) * gcd(a,b) = a*b
		// long lcm = A * B / gcd;
		// find max one line code: long max = (A > B) ? A : B;
		// here lcm we are finding by trying to divide max number with both the no
		// if got divided then that is lcm if not increase till it gets divided
		while (max % A != 0 && max % B != 0)
			max++;

		return new Long[] { max, gcd };

	}
};