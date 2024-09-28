package com.ib.learn.t01basic.p04_basic.math;

public class LP1_CountDigits {

	public static void main(String[] args) {
		System.out.println(new SolutionLP01().countDigit(12235678));
		System.out.println(new SolutionLP01().countDigit(0));
	}

}

class SolutionLP01{
	int countDigit(int n) {
		if(n==0)
			return 1;
		// Convert negative no to positive without using Math.abs()
		// our while logic check if no is less than zero which won't work on negative no
		// so first converted negative into positive cause we just need no of digits.
        if (n < 0) {
            n = -n;
        }
		int count = 0;
		// logic is to divide n with 10 that way each time one digit will get removed
		// why cause integer division discards the remainder.
		while(n>0){
			n = n/10;
			count++;
		}
		return count;
	}
}