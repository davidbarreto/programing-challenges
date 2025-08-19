package br.com.dbarreto.challenge.misc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.ShiftLinkedList;

public class ShiftLinkedListTest {
	
	@Test
	public void case001() {
		ShiftLinkedList problem = new ShiftLinkedList();
		assertEquals(List.of(4, 5, 0, 1, 2, 3), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), 2)));
		assertEquals(List.of(2, 3, 4, 5, 0, 1), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), -2)));
		assertEquals(List.of(0, 1, 2, 3, 4, 5), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), 6)));
		assertEquals(List.of(0, 1, 2, 3, 4, 5), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), 12)));
		assertEquals(List.of(0, 1, 2, 3, 4, 5), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), -12)));
		assertEquals(List.of(5, 0, 1, 2, 3, 4), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), 1)));
		assertEquals(List.of(1, 2, 3, 4, 5, 0), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), -1)));
		assertEquals(List.of(0, 1, 2, 3, 4, 5), toList(problem.solve(toListNode(List.of(0, 1, 2, 3, 4, 5)), 0)));
	}
	
	private ShiftLinkedList.ListNode toListNode(List<Integer> list) {
		
		ShiftLinkedList.ListNode head = new ShiftLinkedList.ListNode();
		head.value = list.get(0);
		ShiftLinkedList.ListNode node = head;
		for (int i = 1; i < list.size(); i++) {
			node.next = new ShiftLinkedList.ListNode();
			node.next.value = list.get(i);
			node = node.next;
		}
		
		return head;
	}
	
	private List<Integer> toList(ShiftLinkedList.ListNode node) {
		
		List<Integer> list = new ArrayList<>();
		while (node != null) {
			list.add(node.value);
			node = node.next;
		}
		return list;
	}
}
