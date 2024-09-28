package com.ib.learn.t01basic.p02_patterns;


/**

Link:
https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/

Approach: 

There are 4 general rules for solving a pattern-based question : 

We always use nested loops for printing the patterns. For the outer loop, we count the number of lines/rows and loop for them.
Next, for the inner loop, we focus on the number of columns and somehow connect them to the rows by forming a logic such that for each row we get the required number of columns to be printed.
We print the ‘*’ inside the inner loop.
Observe symmetry in the pattern or check if a pattern is a combination of two or more similar patterns or not.
 
*/




/**
System.out.println("Pattern - 11: Binary Number Triangle Pattern");

1
01
101
0101
10101
010101

*/

class Pattern11 {

    public Pattern11(int n) {
        System.out.println("--------------" + this.getClass().getSimpleName() + "----------");
        
        boolean dec = true;
        for (int i = 0; i < n; i++) {
        	
        	dec = (i % 2 == 0); // Update with 1 if i is even, 0 if i is odd 0,1,2,3,4
        	
            for (int j = 0; j <= i; j++) {
            	
                if (dec)
                    System.out.print(1);
                else
                    System.out.print(0);
                dec = !dec; // Toggle dec for the next character
            }
            System.out.println();
        }
        System.out.println("--------------" + this.getClass().getSimpleName() + "----------");
    }
	
	void printPattern() {

	}
}

public class Patterns2 {

	public static void main(String[] args) {
		int n = 5;
//		System.out.println("Pattern-1: Rectangular Star Pattern");
//		new Pattern01(n);
//		System.out.println("Pattern-2: Right-Angled Triangle Pattern");
//		new Pattern02(n,true);
//		System.out.println("Pattern - 3: Right-Angled Number Pyramid");
//		new Pattern03(n);
//		System.out.println("Pattern - 4: Right-Angled Number Pyramid - II");
//		new Pattern04(n);
//		System.out.println("Pattern-5: Inverted Right Pyramid");
//		new Pattern05(n,true);
//		System.out.println("Pattern - 6: Inverted Numbered Right Pyramid");
//		new Pattern06(n);
//		System.out.println("Pattern - 7: Star Pyramid");
//		new Pattern07(n, true);
//		System.out.println("Pattern - 8: Inverted Star Pyramid");
//		new Pattern08(n, true);
//		System.out.println("Pattern - 9: Diamond Star Pattern");
//		new Pattern09(n);
//		System.out.println("Pattern - 10: Half Diamond Star Pattern");
//		new Pattern10(n);
		System.out.println("Pattern - 11: Binary Number Triangle Pattern");
		new Pattern11(n);
	}
}
