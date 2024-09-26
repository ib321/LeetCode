# 206. Reverse Linked List

**Difficulty**: Easy

## Problem Statement
Given the head of a singly linked list, reverse the list, and return the reversed list.

### Examples

**Example 1:**
- **Input:** head = [1,2,3,4,5]
- **Output:** [5,4,3,2,1]

**Example 2:**
- **Input:** head = [1,2]
- **Output:** [2,1]

**Example 3:**
- **Input:** head = []
- **Output:** []

### Constraints
- The number of nodes in the list is the range [0, 5000].
- -5000 <= Node.val <= 5000

### Follow Up
A linked list can be reversed either iteratively or recursively. Could you implement both?

### Topics
- Linked List
- Recursion

## Solution

```java
package com.ib.p08_linkedlist;

public class LP31_206_ReverseLinkedList {

	public static void main(String[] args) {
		ListNode node = new Solution().reverseList(new ListNode().InitilizeNode());
		new ListNode().printListNodes(node);
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
class Solution {
	/**
	 * Initialize three pointers-prev as NULL, next as NULL, and curr as head.
	 * Update the next pointer to the next of curr to store the next of curr. (nextN = current.next;)
	 * Update the next of curr as prev to reverse the pointer of the node.(current.next = prev;)
	 * Update prev as curr and curr as next to move to the next node.(prev = current; current = nextN;)
	 * when next become null it ends so condition loop until: current !=null
	 * return prev element pointer because at end of loop current became null prev is the last pointer
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		
		ListNode prev = null;
		ListNode current = head;
		ListNode nextN = null;
		while(current !=null)
		{
			nextN = current.next;
			current.next = prev;
			prev = current;
			current = nextN;
		}
		return prev;
	}
}