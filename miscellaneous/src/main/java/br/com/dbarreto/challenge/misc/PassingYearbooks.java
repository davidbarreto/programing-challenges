package br.com.dbarreto.challenge.misc;

import java.util.HashMap;
import java.util.Map;

public class PassingYearbooks {

	private int computeGroups(int student, int[] arr, Map<Integer, Integer> visited, Map<Integer, Integer> signCount) {

		int count = 0;
		int c = student;
		while (true) {

			c = arr[c - 1];
			if (visited.containsKey(c)) {
				return signCount.get(visited.get(c));
			}

			visited.put(c, student);
			count++;

			if (c == student) {
				break;
			}
		}

		signCount.put(student, count);
		return count;
	}

	public int[] findSignatureCounts(int[] arr) {

		int[] ans = new int[arr.length];

		// Map a student to its root and mark the student as visited
		Map<Integer, Integer> visited = new HashMap<>();

		// Map the root student to the sign count
		Map<Integer, Integer> signCount = new HashMap<>();

		for (int i = 1; i <= arr.length; i++) {
			int size = computeGroups(i, arr, visited, signCount);
			ans[i - 1] = size;
		}

		return ans;
	}
}
