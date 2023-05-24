package br.com.dbarreto.challenge.hackerrank.interview.kit.greedy;

import java.util.HashMap;
import java.util.Map;

public class ReverseShuffleMerge {

    public String reverseShuffleMerge(String s) {
    
        Map<Character, Integer> available = new HashMap<>();
        for (char ch : s.toCharArray()) {
            available.merge(ch, 1, Integer::sum);
        }
        
        Map<Character, Integer> used = new HashMap<>();
        Map<Character, Integer> required = new HashMap<>();
        available.forEach((key, counter) -> required.put(key, counter/2));
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = s.length()-1; i >= 0; i--) {
            
            char ch = s.charAt(i);
            
            available.merge(ch, -1, Integer::sum);
            
            if (used.getOrDefault(ch, 0) >= required.get(ch)) {
            	continue;
            }
            
            while (builder.length() > 0 && ch < builder.charAt(builder.length() - 1) && available.get(builder.charAt(builder.length() - 1)) + used.get(builder.charAt(builder.length() - 1)) > required.get(builder.charAt(builder.length() - 1))) {
            	char removedChar = builder.charAt(builder.length() - 1);
            	builder.deleteCharAt(builder.length() - 1);
            	used.merge(removedChar, -1, Integer::sum);
            }
            
            builder.append(ch);
            used.merge(ch, 1, Integer::sum);
        }
        
        return builder.toString();
    }
}
