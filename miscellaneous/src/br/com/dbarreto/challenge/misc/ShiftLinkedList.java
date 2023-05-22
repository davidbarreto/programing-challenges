package br.com.dbarreto.challenge.misc;

/**
 * Write a function that takes in the head of a
 * Singly Linked List and an integer k, shifts the list
 * by k positions and returns its new head
 * The integer k can either positive or negative, meaning
 * that the Liked List must be sifted to the left or right
 */
public class ShiftLinkedList {

	public ListNode solve(ListNode head, int k) {
	
		int len = 0;
		ListNode node = head;
		ListNode tail = null;
		while (node != null) {
			tail = node;
			node = node.next;
			len++;
		}
		
		int shift = k % len;
		
		if (shift == 0) {
			return head;
		}
		
		tail.next = head;
		int hops = shift < 0 ? -shift : len - shift;

		node = head;
		tail = head;
		while(hops-- > 0) {
			tail = node;
			node = node.next;
		}
		
		tail.next = null;
		return node;
	}
	
	public static class ListNode {
		public int value;
		public ListNode next;
	}
}