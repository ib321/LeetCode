package com.ib.learn.t01basic.p04_basic.math;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(fact(5));
	}

	public static int fact(int num) {
		int i=1,fact=1;
		while(i<=num)
		{
			fact =fact *i;
			i=i+1;
		}
		
		return fact;
	}

}
