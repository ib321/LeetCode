package com.ib.learn.t01basic.p04_basic.math;

public class LP3_09_PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(new SolutionLP03().isPalindrome(121)); //true
		System.out.println(new SolutionLP03().isPalindrome(-121)); // false
		System.out.println(new SolutionLP03().isPalindrome(10));//false
		System.out.println(new SolutionLP03().isPalindrome(2112)); // true
	}

}

class SolutionLP03 {
	// will follow long and int check way for this reverse
	public boolean isPalindrome(int x) {
		// if negative:: -121 reverse id 121- which is not Equal
		if (x < 0)
			return false;
		// using long instead of int.
		long newnum = x;
		long revnum = 0;
		// reverse algo same as int without overflow check
		while (newnum != 0) {
			long rem = newnum % 10;
			revnum = revnum * 10 + rem;
			newnum = newnum / 10;
		}
		int revint = (int) revnum;
		// overflow check here if revnum == revint condition is to check if
		// int counterpart of long is same if yes then no overflow happened
		// 2nd condition to check for Palindrome
		if (revnum == revint && x == revint) {
			return true;
		} else {
			return false;
		}
	}
}