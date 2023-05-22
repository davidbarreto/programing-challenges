package br.com.dbarreto.challenge.misc;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an input array of integers, find two elements whose
 * the sum is exactly 'target'. Consider that is always at least
 * one solution for the problem. You can return any pair that solves
 * the problem. Create a solution considering a sorted input array, 
 * and other an unsorted input array.
 */
public class FindSumOfTwoNumbers {

	public List<Integer> solveUnsorted(List<Integer> numbers, int target) {
		
		Set<Integer> seen = new HashSet<>();
		for (int n : numbers) {
			int seekPair = target - n;
			if (seen.contains(seekPair)) {
				return List.of(n, seekPair);
			} else {
				seen.add(n);
			}
		}
		
		return Collections.emptyList();
	}
	
	public List<Integer> solveSorted(List<Integer> numbers, int target) {
		
		int left = 0;
		int right = numbers.size() -1;
		
		while(left < right) {
			
			int n1 = numbers.get(left);
			int n2 = numbers.get(right);
			int sum = n1 + n2;
			
			if (sum < target) {
				left++;
			} else if (sum > target){
				right--;
			} else {
				return List.of(n1, n2);
			}
		}
		
		return Collections.emptyList();
	}
}
