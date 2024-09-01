# 735. Asteroid Collision

**Difficulty**: Medium

## Problem Statement
We are given an array `asteroids` of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

### Examples

**Example 1:**
- **Input**: `asteroids = [5,10,-5]`
- **Output**: `[5,10]`
- **Explanation**: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

**Example 2:**
- **Input**: `asteroids = [8,-8]`
- **Output**: `[]`
- **Explanation**: The 8 and -8 collide exploding each other.

**Example 3:**
- **Input**: `asteroids = [10,2,-5]`
- **Output**: `[10]`
- **Explanation**: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

### Constraints
- 2 <= asteroids.length <= 10^4
- -1000 <= asteroids[i] <= 1000
- asteroids[i] != 0

### Topics
- Array
- Stack
- Simulation

### Hints
1. Say a row of asteroids is stable. What happens when a new asteroid is added on the right?

## Solution

```java

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
