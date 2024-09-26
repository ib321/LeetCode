package com.ib.p08_linkedlist;


public class LP30_328_OddEvenLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**Definition for singly-linked list.
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
*/

class Solution30 {
	
	/**
	 * The first node is considered odd, and the second node is even, and so on. We
	 * need to group odd one first then even one.
	 * Idea here to
	 * Initialize pointers for odd and even nodes.
	 * Keep the head of the even list to link later to odd last element.
	 * Now comes the loop: condition is based on last element being checked for null
	 * head.next or head.next.next
	 * :: eg. [2,1,3,5,6,4,7]
	 * see this loop in terms of pointer we have two pointers
	 * Set Odd pointer at head[2] = odd
	 * Set Even pointer at head.next[1] = even
	 * -- Next odd element(odd.next)[?] will be next of even(even.next)[3]
	 * -- odd pointer is at head update to odd = odd.next[?=3]
	 * -- update odd pointer how: move it to next odd element 
	 * 
	 * what is next odd element?::funny is this is same element that we got above using even.next 
	 * 
	 * -- update even.next[?] that will be updated odd next element odd.next[5]
	 * same update even pointer
	 * 
	 * @param head
	 * @return
	 */
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;

		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}

		// Link the end of the odd list to the head of the even list.
		odd.next = evenHead;
		return head;
	}
}