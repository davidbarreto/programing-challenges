package br.com.dbarreto.challenge.hackerrank.interview.real;

import java.util.List;

/**
 * Given an array of integers, without reordering, determine the maximum difference
 * between any element and any prior smaller element. If there is never a lower prior
 * element, return -1
 * 
 * Example:
 * arr = [5, 3, 6, 7, 4]
 * 
 * There are no earlier elements than arr[0]
 * There is no earlier reading with a value lower than arr[1]
 * There are two lower earlier readings with a value lower than arr[2] = 6:
 * 
 * arr[2] - arr[1] = 6 - 3 = 3
 * arr[2] - arr[0] = 6 - 5 = 1
 * 
 * There is one lower earlier reading with a lower value than arr[4] = 4:
 * 
 * arr[4] - arr[1] = 4 - 3 = 1
 * 
 * The maximum trailing records is arr[3] - arr[1] = 4
 * 
 * Constraints:
 * 
 * 1 <= n <= 2*10^5
 * -10^6 <= arr[i] <= 10^6 and 0 <= i < n
 * 
 * @author david
 *
 */
public class RiverRecords {
	
	
	public int maximumTrailing(List<Integer> arr) {

		int minimum = arr.get(0);
		int maxDifference = -1;
		for (int i = 1; i < arr.size(); i++) {
			maxDifference = Math.max(maxDifference, arr.get(i) - minimum);
			minimum = Math.min(minimum, arr.get(i));
		}
		
		return maxDifference;
	}

}
