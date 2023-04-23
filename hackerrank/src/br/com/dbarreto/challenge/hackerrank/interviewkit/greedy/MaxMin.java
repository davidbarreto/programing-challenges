package br.com.dbarreto.challenge.hackerrank.interviewkit.greedy;

import java.util.Collections;
import java.util.List;

public class MaxMin {
	
	public int maxMin(int k, List<Integer> arr) {
		Collections.sort(arr);
        int unfairness = Math.abs(arr.get(k-1) - arr.get(0));
        for(int i = 0; i< arr.size() - k+1; i++){
            int currentDiff = Math.abs(arr.get(i+k-1) - arr.get(i));
            if(unfairness > currentDiff) {
                unfairness = currentDiff;    
            }
        }
        return unfairness;
    }
}
