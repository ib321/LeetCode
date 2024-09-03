# 649. Dota2 Senate

**Difficulty**: Medium

## Problem Statement
In the world of Dota2, there are two parties: the Radiant and the Dire.

The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
- Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
- Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.

Given a string `senate` representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are `n` senators, the size of the given string will be `n`.

The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.

Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".

### Examples

**Example 1:**
- **Input**: `senate = "RD"`
- **Output**: `"Radiant"`
- **Explanation**: 
  - The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
  - The second senator can't exercise any rights anymore since his right has been banned. 
  - In round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.

**Example 2:**
- **Input**: `senate = "RDD"`
- **Output**: `"Dire"`
- **Explanation**: 
  - The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
  - The second senator can't exercise any rights anymore since his right has been banned. 
  - The third senator comes from Dire and he can ban the first senator's right in round 1. 
  - In round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.

### Constraints
- n == senate.length
- 1 <= n <= 10^4
- senate[i] is either 'R' or 'D'.

### Topics
- String
- Greedy
- Queue

## Solution

```java

package com.ib.p07_queue;

import java.util.*;

public class LP28_649_Dota2Senate {

	public static void main(String[] args) {

		// new Solution28().predictPartyVictory("RDDDRDRRDR");// D
		new Solution28().predictPartyVictory("DDDRRRRR");

	}
}

class Solution28 {
	/**
	 * problem explanation here:
	 * https://leetcode.com/problems/dota2-senate/solutions/3483399/simple-diagram-explanation/?source=submission-noac
	 * Approach here for 1 & 2 method
	 * 
	 * basically we have to start from start
	 * now always first person will exercise their vote
	 * they will always ban other party first found people for win
	 * after they ban they will move to last cause they still have power to vote
	 * 
	 * Created a queue and stored all the senates
	 * now looping on queue 
	 * once i find R at first I remove D and remove the R from start and add R to last
	 * once i find D at first I remove R and remove the D from start and add D to last
	 * simple
	 * 
	 * counting is solely to just break the while loop once counter for any party goes to 0
	 * I used to check the queue if it has only one party but that loop was expensive time so counter
	 * 
	 * @param senate
	 * @return
	 */
	public String predictPartyVictory(String senate) {
		Queue<Character> queue = new LinkedList<>();
		int countR = 0, countD = 0;

		for (char c : senate.toCharArray()) {
			queue.add(c);
			if (c == 'R') countR++;
            else countD++;
		}

		while (countR > 0 && countD > 0) {

			char first = queue.peek();

			if (first == 'R') {
				if (queue.remove('D')) {
					countD--;
					queue.poll();
					queue.add('R');

				}

			} else if (first == 'D') {
				if (queue.remove('R')) {
					countR--;
					queue.poll();
					queue.add('D');
				}
			}

		}

		System.out.println(queue.peek());
		return countR > 0 ? "Radiant" : "Dire";
	}
	
	//full brute force it was failing with time limit exceeded
	// due to there is for loop inside while.
	public String predictPartyVictory2(String senate) {
		Queue<Character> queue = new LinkedList<>();

		char[] chararr = senate.toCharArray();

		for (char c : chararr) {
			queue.add(c);
		}

		while (queue.size() > 1) {

			char first = queue.peek();

			// Check if all elements in the queue are the same within the while loop
			boolean allSame = true;
			for (char c : queue) {
				if (c != first) {
					allSame = false;
				}
			}
			if (allSame) {
				break;
			}

			if (first == 'R') {
				if (queue.remove('D')) {
					queue.poll();
					queue.add('R');

				}

			} else if (first == 'D') {
				if (queue.remove('R')) {
					queue.poll();
					queue.add('D');
				}
			}

		}

		//System.out.println(queue.toString());
		String out = "";
		if (queue.peek() == 'R')
			out = "Radiant";
		else if (queue.peek() == 'D')
			out = "Dire";
		return out;
	}
}




