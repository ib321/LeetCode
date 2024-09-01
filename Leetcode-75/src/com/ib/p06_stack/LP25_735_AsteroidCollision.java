package com.ib.p06_stack;

import java.util.Arrays;
import java.util.*;

public class LP25_735_AsteroidCollision {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution25().asteroidCollision(new int[] { 5, 10, -5 })));

	}
}

class Solution25 {
	
	/**
	 * Goal is to find final asteroid after all collision.
	 * 
	 * Approach is like::
	 * condition 2:
	 * if asteroid > 0 ( Moving Right ) :: directly put into stack :: won't collide
	 * condition 3:
	 * if asteroid < 0 ( Moving Left ) but last asteroid < 0 (Moving left) :: put into stack
	 * condition 1:
	 * We are assuming for condition where asteroid < 0 ( Moving Left ) & last asteroid > 0 (Moving right)
	 * in this we have Alert for collision :: Inside we have two check
	 * 1. for if asteroid is big pop last asteroid and continue; so both destroyed.
	 * 2. for if asteroid is equal stack pop remove last asteroid & alive false so won't add asteroid
	 * 3. auto execute if asteroid is small alive is false so it gets destroyed and won't add
	 *
	 * @param asteroids
	 * @return
	 */
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer ast : asteroids) {
			boolean alive = true;

			while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
				if (stack.peek() < -ast) {
					stack.pop();
					continue;
				} else if (stack.peek() == -ast) {
					stack.pop();
				}
				alive = false;
				break;
			}
			if (alive)
				stack.push(ast);
		}

		int[] leftAstroide = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			leftAstroide[i] = stack.pop();
		}
		return leftAstroide;
	}
}
