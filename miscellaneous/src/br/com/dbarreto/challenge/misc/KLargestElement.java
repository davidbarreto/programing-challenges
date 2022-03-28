package br.com.dbarreto.challenge.misc;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestElement {

	public int solveUsingHeap(List<Integer> arr, int k) {
		
		PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		heap.addAll(arr);
		
		while(k-- > 1) {
			heap.poll();
		}
		
		return heap.peek();
	}
	
	public int solveUsingSort(List<Integer> arr, int k) {
		arr.sort(Comparator.naturalOrder());
		return arr.get(arr.size() - k);
	}
}
