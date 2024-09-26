package com.ib.p08_linkedlist;

public class LP29_2095_DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}

 
class Solution29 {
	
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
	// [1,3,4,7,1,2,6] -- [1,3,4,7,2,6] for condition middle-1
}