package br.com.dbarreto.challenge.hackerrank.certification;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NiceTeams {
	
	/**
	 * A coach of a school chess club wants to start a mentoring program for newer players. Each player has an integer rating
	 * representing skill level. The coach would like to pair up students whose ratings differ by no less than a given minimum.
	 * What is the maximum number of pairs that can be formed?
	 * 
	 * @param skillLevel List of integers representing the chess skill level of each student
	 * @param minDiff The minimum difference between two students in a team
	 * @return
	 */

	public int maxTeams(List<Integer> skillLevel, int minDiff) {
		
		Set<Integer> chosenPairs = new HashSet<>();
		skillLevel.sort(Comparator.naturalOrder());
		
		int lastIndex = skillLevel.size() - 1;
		int lastElement = skillLevel.get(lastIndex);
		
		for (int i = 0; i < skillLevel.size(); i++) {
			
			int val = skillLevel.get(i);
			int key = val + minDiff;
			
			if (key > lastElement) {
				break;
			}
			
			int index = Collections.binarySearch(skillLevel, key);
			if (index < 0) {
				index = -index -1;
			}
			
			if (index == skillLevel.size()) {
				break;
			}
			
			while(chosenPairs.contains(index)) {
				index++;
			}
			
			if (index <= lastIndex) {
				chosenPairs.add(index);
			}
		}
		return chosenPairs.size();
	}
}
