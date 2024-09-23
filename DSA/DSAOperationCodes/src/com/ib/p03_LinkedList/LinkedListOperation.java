package com.ib.p03_LinkedList;

public class LinkedListOperation {

	public static void main(String[] args) {
		// Singly Linked List 1 -> 2 -> 3
		new LinkedList().mainLinkedList();
		// Double Linked List 1 <-> 2 <-> 3
		new DoubleLinkedList().mainDoubleLinkedList();
		// Create circular linked list: 2, 3, 4
		new CircularLinkedList().mainCircular();
		// 
		new CircularDoubleLinkedList().mainDoubleCircular();
	}
}

//Node for Singly Linked List
class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

//Node2 for doubly Linked List
class Node2 {
	int data;
	Node2 next;
	Node2 prev;

	public Node2(int data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class LinkedList {
	// Defined to be used for Node: singly linked list
	public static void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}

	void mainLinkedList() {
		Node head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		head.next = second;
		second.next = third;

		printList(head);
		System.out.println();
	}
}

class DoubleLinkedList {
	
	// Defined to be used for Node2: doubly Linked List
	static void forwardTraversal(Node2 head) {
		Node2 curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	// Defined to be used for Node2: doubly Linked List
	static void backwardTraversal(Node2 tail) {
		Node2 curr = tail;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.prev;
		}
		System.out.println();
	}

	void mainDoubleLinkedList() {
		Node2 head = new Node2(1);
		Node2 second = new Node2(2);
		Node2 third = new Node2(3);

		head.next = second;

		second.prev = head;
		second.next = third;

		third.prev = second;

		System.out.println("Forward Traversal:");
		forwardTraversal(head);

		System.out.println("Backward Traversal:");
		backwardTraversal(third);
	}

}

class CircularLinkedList {
	// Defined to be used with Node: singly linked list :: Circular
	static void printListCircular(Node last) {
		if (last == null)
			return;

		Node head = last.next;
		while (true) {
			System.out.print(head.data + " ");
			head = head.next;
			if (head == last.next)
				break;
		}
		System.out.println();
	}

	void mainCircular() {

		Node first = new Node(2);
		first.next = new Node(3);
		first.next.next = new Node(4);
		Node last = first.next.next;
		last.next = first;

		printListCircular(last);
	}

}

class CircularDoubleLinkedList {

	static void forwardTraversalCircular(Node2 head) {
		Node2 curr = head;
		if (head != null) {
			do {
				System.out.print(curr.data + " ");
				curr = curr.next;
			} while (curr != head);
		}
		System.out.println();
	}

	static void backwardTraversalCircular(Node2 head) {
		Node2 curr = head.prev;
		if (head != null) {
			do {
				System.out.print(curr.data + " ");
				curr = curr.prev;
			} while (curr.next != head);
		}
		System.out.println();
	}

	// Create a doubly circular linked list
	// 1 <-> 2 <-> 3 <-> 1
	void mainDoubleCircular() {
		Node2 head = new Node2(1);
		Node2 second = new Node2(2);
		Node2 third = new Node2(3);

		head.next = second;
		second.prev = head;
		second.next = third;
		third.prev = second;
		third.next = head;
		head.prev = third;

		System.out.println("Forward Traversal:");
		forwardTraversalCircular(head);

		System.out.println("Backward Traversal:");
		backwardTraversalCircular(head);
	}
}
