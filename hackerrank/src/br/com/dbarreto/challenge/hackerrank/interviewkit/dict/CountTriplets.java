package br.com.dbarreto.challenge.hackerrank.interviewkit.dict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

	public long countTriplets(List<Long> arr, long r) {
	    Map<Long, Long> countMap = new HashMap<>();
	    Map<Long, Long> pairsMap = new HashMap<>();
	    long count = 0;

	    for (long num : arr) {
	        if (num % r == 0) {
	            long pre = num / r;
	            Long cnt2 = pairsMap.get(pre);
	            if (cnt2 != null) {
	                count += cnt2;
	            }

	            Long cnt1 = countMap.get(pre);
	            if (cnt1 != null) {
	                pairsMap.merge(num, cnt1, Long::sum);
	            }
	        }

	        countMap.merge(num, 1L, Long::sum);

	        System.out.println(String.format("num: %d, countMap: %s, pairsMap: %s, count: %d", 
	                            num, countMap, pairsMap, count));
	    }

	    return count;
	}
}
