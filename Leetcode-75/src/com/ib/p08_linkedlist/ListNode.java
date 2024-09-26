package com.ib.p08_linkedlist;

//Definition for singly-linked list.
public class ListNode {
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

	public ListNode InitilizeNode() {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		ListNode node4 = new ListNode(4);
		node3.next = node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		
		return node1;
	}

	public void printListNodes(ListNode n) {
		while (n != null) {
			System.out.print(n.val + " ");
			n = n.next;
		}

	}
}
