package br.com.dbarreto.challenge.misc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find the best apartment that satisfies your requirements
 * Received a list of blocks that have apartment and requirements (gym, train station, school, store, etc)
 * Calculate the block where it's better to buy the apartment, minimizing the distance to reach all requirements
 * Consider that all blocks have apartments;
 * Consider that there is a single solution;
 */
public class BestApartment {

	public int findApartment(List<List<Boolean>> block, List<Integer> requirements) {
		
		// block: {{false, true}, {true, true}, {false, false}}
		// reqs: [0, 1]
		Set<Integer> reqs = new HashSet<>(requirements);
		int[][] distances = createDistancesArray(block);
		
		updateFromLeft(block, distances, reqs);
		updateFromRight(block, distances, reqs);
		
		return calculateResult(distances);
	}
	
	private int calculateResult(int[][] distances) {
		
		int minOverallDistance = Integer.MAX_VALUE;
		int minIndex = 0;
		for (int i = 0; i < distances.length; i++) {
			
			int maxFeatureDistance = Integer.MIN_VALUE;
			for (int j = 0; j < distances[0].length; j++) {
				if (distances[i][j] > maxFeatureDistance) {
					maxFeatureDistance = distances[i][j];
				}
			}
			
			if (maxFeatureDistance < minOverallDistance) {
				minOverallDistance = maxFeatureDistance;
				minIndex = i;
			}
		}
		
		return minIndex;
	}
	
	private void updateFromLeft(List<List<Boolean>> block, int[][] distances, Set<Integer> reqs) {
		for (int i = 1; i < block.size(); i++) {
			for (int j = 0; j < block.get(i).size(); j++) {
				if (reqs.contains(j) && distances[i-1][j] != Integer.MAX_VALUE) {
					distances[i][j] = Math.min(distances[i][j], distances[i-1][j] + 1);
				}
			}
		}
	}
	
	private void updateFromRight(List<List<Boolean>> block, int[][] distances, Set<Integer> reqs) {
		for (int i = block.size() - 2; i >= 0 ; i--) {
			for (int j = 0; j < block.get(i).size(); j++) {
				if (reqs.contains(j) && distances[i+1][j] != Integer.MAX_VALUE) {
					distances[i][j] = Math.min(distances[i][j], distances[i+1][j] + 1);
				}
			}
		}
	}

	private int[][] createDistancesArray(List<List<Boolean>> block) {
		int[][] distances = new int[block.size()][block.get(0).size()];
		for (int i = 0; i < distances.length; i++) {
			for (int j = 0; j < distances[0].length; j++) {
				if (block.get(i).get(j)) {
					distances[i][j] = 0;
				} else {
					distances[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		return distances;
	}
}
