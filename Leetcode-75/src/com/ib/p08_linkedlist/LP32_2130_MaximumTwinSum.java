package com.ib.p08_linkedlist;

public class LP32_2130_MaximumTwinSum {

	public static void main(String[] args) {
		int sum = new Solution32().pairSum(new ListNode().InitilizeNode());
		System.out.println(sum);

	}
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution32 {
	/**
	 * We Need to find max sum of twin node::
	 * Twin nodes are defined as nodes at positions i and (n-1-i).
	 * basically 1-8,2-7,3-6,4-5 for 12345678
	 * Approach is to divide the list into two halves, reverse the second half,
	 * then start adding from initial of these both list
     * and then calculate the max twin sums.
     * 
	 * @param head
	 * @return
	 */
	public int pairSum(ListNode head) {
		if (head == null) {
			return 0;
		} else if (head.next == null) {
			return head.val;
		}

		// find middle node using rabbit tortoise method
		// when fast pointer reaches the end slow pointer points to the node just before
		// the middle node.
		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode middleNode = slow.next;
		//System.out.println(middleNode.val);

		// Reverse the second half of the list
		ListNode prev = null;
		ListNode current = middleNode;
		ListNode next = null;

		while (current != null) {
			next = current.next; // store next element in next
			current.next = prev; // reverse the current node
			prev = current; // update prev to current
			current = next; // update current to next
		}

		// Calculate the twin sums
		ListNode firstHalf = head;
		ListNode secondHalf = prev;

		int maxSum = 0;
		while (secondHalf != null) {
			int sum = firstHalf.val + secondHalf.val;
			if (sum > maxSum)
				maxSum = sum;
			firstHalf = firstHalf.next;
			secondHalf = secondHalf.next;
		}

		return maxSum;
	}
}

