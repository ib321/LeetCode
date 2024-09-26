# 2095. Delete the Middle Node of a Linked List

**Difficulty**: Medium

## Problem Statement
You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.
The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
- For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.

### Examples

**Example 1:**
- **Input:** head = [1,3,4,7,1,2,6]
- **Output:** [1,3,4,1,2,6]
- **Explanation:** 
  - The above figure represents the given linked list. The indices of the nodes are written below.
  - Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
  - We return the new list after removing this node.

**Example 2:**
- **Input:** head = [1,2,3,4]
- **Output:** [1,2,4]
- **Explanation:** 
  - The above figure represents the given linked list.
  - For n = 4, node 2 with value 3 is the middle node, which is marked in red.

**Example 3:**
- **Input:** head = [2,1]
- **Output:** [2]
- **Explanation:** 
  - The above figure represents the given linked list.
  - For n = 2, node 1 with value 1 is the middle node, which is marked in red.
  - Node 0 with value 2 is the only node remaining after removing node 1.

### Constraints
- The number of nodes in the list is in the range [1, 10^5].
- 1 <= Node.val <= 10^5

### Topics
- Linked List
- Two Pointers

### Hints
1. If a point with a speed s moves n units in a given time, a point with speed 2 * s will move 2 * n units at the same time. Can you use this to find the middle node of a linked list?
2. If you are given the middle node, the node before it, and the node after it, how can you modify the linked list?

## Solution

```java

package com.ib.p08_linkedlist;

public class LP29_2095_DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
 
class Solution {
	
	/**
	 * Two pointer approach:
	 * check if total 0,1 element then return null
	 * start slow at 0 index and fast at 2 index of head
	 * update fast always two element (4) update slow 1 step (1)
	 * when fast pointer reaches the end slow pointer will point to the node just before the middle node.
	 * Set slow.next to slow.next.next to skip the middle node and remove it from the list
	 * Return the head of the modified list.
	 * @param head
	 * @return
	 */
	public ListNode deleteMiddle(ListNode head) {
		if (head.next == null || head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head.next.next;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return head;
	}
	
	
	/**
	 * Need to delete the middle element of linked list.
	 * Approach is to find the total length of linked list.
	 * find middle element index 
	 * loop till <middleNode-1 then this loop stops at just left of middle node
	 * now just update it's next element address with next.next
	 * @param head
	 * @return
	 */
	public ListNode deleteMiddle2(ListNode head) {
		if(head == null || head.next == null )
		{
			return null;
		}
			
        ListNode newHead = head;
		int totalElement = 0;

		while(newHead != null)
		{
			newHead = newHead.next;
			totalElement++;
		}
		int middleNode = totalElement/2;
		newHead = head;
		// why condition middleNode-1 because 
		// the first newHead is the second head so loop actually starts from next head.
    	for(int i=0;i<middleNode-1;i++)
    	{
    		newHead = newHead.next;
    		//System.out.println(newHead.val);
    	}
    	//at <middleNode-1 is middle-1 element update it with next element.
    	newHead.next = newHead.next.next;
		return head;
    }
}