package com.ib.learn.t01basic.p04_basic.math;

public class LP5_ArmStrongNum {

	public static void main(String[] args) {
		System.out.println(SolutionLP05.isArmstrong(371));
		System.out.println(SolutionLP05.isArmstrong(153));
	}

}

class SolutionLP05 {
	/**
	 * An Amrstrong number is a number that is equal to the sum of its own digits
	 * each raised to the power of the number of digits.
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isArmstrong(int num) {

		// first find the number of digit
		int count = 0;
		int temp = num;
		while (temp != 0) {
			temp = temp / 10;
			count++;
		}

		// find sum of it's digit raised to power of no of digit;
		int n = num;
		int sum = 0;
		while (n != 0) {
			int rem = n % 10;
			//can be used for power calc: for (int i = 0; i < count; i++) { power *= rem; }
			sum = (int) (sum + Math.pow(rem, count));
			n = n / 10;
		}
		System.out.println(sum);
		return sum == num;

	}
};