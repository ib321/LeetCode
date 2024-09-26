# 2130. Maximum Twin Sum of a Linked List

**Difficulty**: Medium

## Problem Statement
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
- For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.
Given the head of a linked list with even length, return the maximum twin sum of the linked list.

### Examples

**Example 1:**
- **Input:** head = [5,4,2,1]
- **Output:** 6
- **Explanation:** 
  - Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
  - There are no other nodes with twins in the linked list.
  - Thus, the maximum twin sum of the linked list is 6.

**Example 2:**
- **Input:** head = [4,2,2,3]
- **Output:** 7
- **Explanation:** 
  - The nodes with twins present in this linked list are:
    - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
    - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
  - Thus, the maximum twin sum of the linked list is max(7, 4) = 7.

**Example 3:**
- **Input:** head = [1,100000]
- **Output:** 100001
- **Explanation:** 
  - There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.

### Constraints
- The number of nodes in the list is an even integer in the range [2, 10^5].
- 1 <= Node.val <= 10^5

### Topics
- Linked List
- Two Pointers
- Stack

### Hints
1. How can "reversing" a part of the linked list help find the answer?
2. We know that the nodes of the first half are twins of nodes in the second half, so try dividing the linked list in half and reverse the second half.
3. How can two pointers be used to find every twin sum optimally?
4. Use two different pointers pointing to the first nodes of the two halves of the linked list. The second pointer will point to the first node of the reversed half, which is the (n-1-i)th node in the original linked list. By moving both pointers forward at the same time, we find all twin sums.

## Solution

```java
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

