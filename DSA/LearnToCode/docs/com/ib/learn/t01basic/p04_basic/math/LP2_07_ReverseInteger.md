# 7. Reverse Integer

**Difficulty**: Medium

## Problem Statement
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

### Examples

**Example 1:**
- **Input:** x = 123
- **Output:** 321

**Example 2:**
- **Input:** x = -123
- **Output:** -321

**Example 3:**
- **Input:** x = 120
- **Output:** 21

### Constraints
- -2^31 <= x <= 2^31 - 1

### Topics
- Math

## Solution

```java
package com.ib.learn.p01_basic.t1_math;

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