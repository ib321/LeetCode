```java

package com.ib.learn.p00_patterns;

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

System.out.println("Pattern-1: Rectangular Star Pattern");


*****
*****
*****
*****
*****

 */
class Pattern01 {

	public Pattern01(int n) {
		System.out.println("--------------"+this.getClass().getSimpleName()+"----------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------"+this.getClass().getSimpleName()+"----------");
	}
	
	void printPattern() {

	}
}

/**
		System.out.println("Pattern-2: Right-Angled Triangle Pattern");

 *
 **
 ***
 ****
 *****

 */
class Pattern02 {
	
	public Pattern02(int n, boolean b) {
		if(b)
		System.out.println("--------------"+this.getClass().getSimpleName()+"----------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		if(b)
		System.out.println("--------------"+this.getClass().getSimpleName()+"----------");
	}
	
	void printPattern() {
		
	}
}

/**

		System.out.println("Pattern - 3: Right-Angled Number Pyramid");
1
12
123
1234
12345

 */
class Pattern03 {
	
	public Pattern03(int n) {
		System.out.println("--------------"+this.getClass().getSimpleName()+"Start----------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
		System.out.println("--------------"+this.getClass().getSimpleName()+"End----------");
	}

	void printPattern() {
		
	}
}


/**
System.out.println("Pattern - 4: Right-Angled Number Pyramid - II");

1
22
333
4444
55555

 */
class Pattern04 {
	
	public Pattern04(int n) {
		System.out.println("--------------"+this.getClass().getSimpleName()+"Start----------");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i+1);
			}
			System.out.println();
		}
		System.out.println("--------------"+this.getClass().getSimpleName()+"End----------");
	}

	void printPattern() {
		
	}
}

/**
System.out.println("Pattern-5: Inverted Right Pyramid");

*****
****
***
**
*

 */
class Pattern05 {
	
	public Pattern05(int n, boolean b) {
		if(b)
		System.out.println("--------------"+this.getClass().getSimpleName()+"Start----------");
		for (int i = n; i >0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		if(b)
		System.out.println("--------------"+this.getClass().getSimpleName()+"End----------");
	}
	
	void printPattern() {
		
	}
}

/**
System.out.println("Pattern - 6: Inverted Numbered Right Pyramid");

12345
1234
123
12
1

 */
class Pattern06 {
	
	public Pattern06(int n) {
		System.out.println("--------------"+this.getClass().getSimpleName()+"Start----------");
		for (int i = n; i >0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
		System.out.println("--------------"+this.getClass().getSimpleName()+"End----------");
	}
	
	void printPattern() {
		
	}
}

/**
		System.out.println("Pattern - 7: Star Pyramid");

    *    
   ***   
  *****  
 ******* 
*********

4space*4space
3space***3space
2space*****2space

 */
class Pattern07 {
	
	// print space before *
	// print *
	// print space after *
	public Pattern07(int n, boolean b) {
		if(b)
		System.out.println("--------------"+this.getClass().getSimpleName()+"Start----------");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n-i-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i*2+1; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < n-i-1; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		if(b)
		System.out.println("--------------"+this.getClass().getSimpleName()+"End----------");
	}
	
	void printPattern() {
		
	}
}

/**
		System.out.println("Pattern - 8: Inverted Star Pyramid");

 *********
  *******
   ***** 
    ***    
     *

0 - 5 - 9 
1 - 5 - 7 (5-1)*2 - 1
2 - 5 - 5 (5-2)*2 -1
3 - 5 - 3 
4 - 5 - 1

spaces are equal to outer loop var
for * we have formula derived from above (n-i)*2-1
 	*********
1space*******1space
2space*****2space
3space***3space
4space*4space
*/
class Pattern08 {

// print space before *
// print *
// print space after *
	public Pattern08(int n, boolean b) {
		if(b)
		System.out.println("--------------" + this.getClass().getSimpleName() + "Start----------");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (n - i) * 2 - 1; j++) {
				System.out.print("*");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		if(b)
		System.out.println("--------------" + this.getClass().getSimpleName() + "End----------");
	}

	void printPattern() {

	}
}


/**
System.out.println("Pattern - 9: Diamond Star Pattern");

     *
    ***
   ***** 
  *******
 *********
 *********
  *******
   ***** 
    ***    
     *

Just put above two logic together
start pyramid Pattern 07 + inverted pyramid pattern 08
 */
class Pattern09 {

	public Pattern09(int n) {
		System.out.println("--------------" + this.getClass().getSimpleName() + "Start----------");
		
		new Pattern07(n,false);
		new Pattern08(n,false);
		
		System.out.println("--------------" + this.getClass().getSimpleName() + "End----------");
	}
	
	void printPattern() {
	
	}
}

/**
System.out.println("Pattern - 10: Half Diamond Star Pattern");

     *
     **
     *** 
     ****
     *****
     ******  
     *****
     ****
     ***    
     **
     *

Just put above two logic together
pattern 2 and pattern 5
 */
class Pattern10 {

	public Pattern10(int n) {
		System.out.println("--------------" + this.getClass().getSimpleName() + "Start----------");
		
		new Pattern02(n,false);
		new Pattern05(n,false);
		
		System.out.println("--------------" + this.getClass().getSimpleName() + "End----------");
	}
	
	void printPattern() {
	
	}
}

public class Patterns {

	public static void main(String[] args) {
		int n = 5;
		System.out.println("Pattern-1: Rectangular Star Pattern");
		new Pattern01(n);
		System.out.println("Pattern-2: Right-Angled Triangle Pattern");
		new Pattern02(n,true);
		System.out.println("Pattern - 3: Right-Angled Number Pyramid");
		new Pattern03(n);
		System.out.println("Pattern - 4: Right-Angled Number Pyramid - II");
		new Pattern04(n);
		System.out.println("Pattern-5: Inverted Right Pyramid");
		new Pattern05(n,true);
		System.out.println("Pattern - 6: Inverted Numbered Right Pyramid");
		new Pattern06(n);
		System.out.println("Pattern - 7: Star Pyramid");
		new Pattern07(n, true);
		System.out.println("Pattern - 8: Inverted Star Pyramid");
		new Pattern08(n, true);
		System.out.println("Pattern - 9: Diamond Star Pattern");
		new Pattern09(n);
		System.out.println("Pattern - 10: Half Diamond Star Pattern");
		new Pattern10(n);
	}

}
