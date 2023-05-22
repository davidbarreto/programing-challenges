package br.com.dbarreto.challenge.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Return a list containing the size of all rivers represented by matrix
 * The rivers just goes to the vertical and horizontal, never in diagonals
 * The resulting list must be sorted.
 */
public class RiverSizes {
	
	public List<Integer> solve(int[][] matrix) {
		
		List<Integer> ans = new ArrayList<>();
		Set<String> visited = new HashSet<>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int riverSize = explore(matrix, i, j, visited);
				if (riverSize > 0) {
					ans.add(riverSize);
				}
			}
		}
		ans.sort(Comparator.naturalOrder());
		return ans;
	}
	
	private int explore(int[][] matrix, int i, int j, Set<String> visited) {
		
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return 0;
		}
		
		if (matrix[i][j] == 0) {
			return 0;
		}
		
		String key = String.format("%d;%d", i, j);
		if (visited.contains(key) ) {
			return 0;
		}
		
		visited.add(key);
		
		return 1 + explore(matrix, i+1, j, visited) +
				explore(matrix, i-1, j, visited) +
				explore(matrix, i, j-1, visited) +
				explore(matrix, i, j+1, visited);
	}
}
