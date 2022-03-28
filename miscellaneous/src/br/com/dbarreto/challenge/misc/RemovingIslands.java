package br.com.dbarreto.challenge.misc;

import java.util.HashSet;
import java.util.Set;

public class RemovingIslands {

	
	public int[][] remove(int[][] matrix) {
	
		Set<String> visited = new HashSet<>();
		for (int j = 0; j < matrix[0].length; j++) {
			explore(matrix, 0, j, visited);
			explore(matrix, matrix.length -1, j, visited);
		}
		
		for (int i = 0; i < matrix.length; i++) {
			explore(matrix, i, 0, visited);
			explore(matrix, i, matrix[0].length -1, visited);
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 1 && !visited.contains(i + ";" + j)) {
					matrix[i][j] = 0;
				}			}
		}

		
		return matrix;
	}
	
	private void explore(int[][] matrix, int i, int j, Set<String> visited) {
		
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
			return;
		}
		
		if (matrix[i][j] == 0) {
			return;
		}
		
		String key = i + ";" + j;
		if (visited.contains(key)) {
			return;
		}
		
		visited.add(key);
		
		explore(matrix, i, j+1, visited);
		explore(matrix, i, j-1, visited);
		explore(matrix, i+1, j, visited);
		explore(matrix, i-1, j, visited);
	}
	
	/**
	 * 
	 *         1 0 0 0 
	 *         1 0 0 0
	 *         0 1 0 0
	 *         0 0 0 0
	 *         0 0 0 0
	 * 
	 */
}
