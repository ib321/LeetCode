package com.ib.learn.t01basic.p04_basic.math;

public class LP2_07_ReverseInteger {

	public static void main(String[] args) {
		System.out.println(new SolutionLP02().reverse(12345));
		System.out.println(new SolutionLP02().reverse(0));
		System.out.println(new SolutionLP02().reverse(-78526));
		System.out.println(new SolutionLP02().reverse(2147483346));
	}

}

class SolutionLP02 {
	public int reverse(int x) {
		int revX = 0;
		while (x != 0) {
			int rem = x % 10;

			// Overflow handling :: on next step we are multiplying by 10 so if multiplying by 10 overflow
			// can be checked by revX * 10 > Integer.MAX_VALUE / 10 * 10 is revX * 10 > Integer.MAX_VALUE
			// why not directly revX * 10 > Integer.MAX_VALUE cause if we multiply to check it would already overflow
			if (revX > Integer.MAX_VALUE / 10 || (revX == Integer.MAX_VALUE / 10 && rem > 7))
				return 0;
			if (revX < Integer.MIN_VALUE / 10 || (revX == Integer.MIN_VALUE / 10 && rem < -8))
				return 0;
			// using this formula to reverse eg. 1234 rev. 4*10^3 + 3*10^2 + 2*10^1 + 1
			// revX = (int) (revX + Math.pow(10, --count) * rem) can be used as well
			revX = revX * 10 + rem;
			x = x / 10;
		}
//		use below 
//		After the loop, the code checks if rev can be cast to an int without losing information.
//		If rev is within the range of an int, the cast will be successful, and the reversed number is returned.
//		If rev exceeds the range of an int, the cast will fail, and the code returns 0, indicating an overflow.
//		long revX = 0
//		if(revX == (revX)rev)
//		    return (int)revX;
//		else
//		    return 0;
		
		return revX;
	}
}