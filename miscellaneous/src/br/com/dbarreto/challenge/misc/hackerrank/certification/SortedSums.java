package br.com.dbarreto.challenge.misc.hackerrank.certification;

import java.util.ArrayList;
import java.util.List;

public class SortedSums {

	private static final int MODULO = 1_000_000_007;
	
	public int sortedSum(List<Integer> arr) {
		
		List<Integer> sorted = new ArrayList<>(arr.size());
		int sum = 0;
		for (Integer e : arr) {
			
			sorted.add(e);
			insertionSort(sorted);
			int f = 0;
			for (int i = 0; i < sorted.size(); i++) {
				f += (((i+1) * (sorted.get(i) % MODULO)) % MODULO);
			}
			
			sum += (f % MODULO);
		}
		
		return sum % MODULO;
	}
	
	private void insertionSort(List<Integer> arr) {
		
		for (int i = 1; i < arr.size(); i++) {
			int aux = arr.get(i);
			int j = i;
			
			while ((j > 0) && arr.get(j-1) > aux) {
				arr.set(j, arr.get(j-1));
				j--;
			}
			
			arr.set(j, aux);
		}
	}
}
