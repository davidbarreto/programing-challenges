package br.com.dbarreto.challenge.book.crackingcodeinterview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design a method to find the frequency of occurrences of any given word in a
 * book. What if we were running this algorithm multiple times?
 */
public class WordFrequencies {
	
	
	private Map<String, Integer> wordCounter = new HashMap<>();
	
	public WordFrequencies(List<String> book) {
		countFrequencies(book);
	}
	
	private void countFrequencies(List<String> book) {
		for (String word : book) {
			wordCounter.merge(word, 1, Integer::sum);
		}
	}

	public Integer solve(String wordToCount) {
		return wordCounter.get(wordToCount);
	}
}
