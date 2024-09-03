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




