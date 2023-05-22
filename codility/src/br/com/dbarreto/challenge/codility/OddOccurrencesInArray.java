package br.com.dbarreto.challenge.codility;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashSet;
import java.util.Iterator;

class OddOccurrencesInArray {
    public int solution(int[] A) {
        
        HashSet<Integer> group = new HashSet<>();
        
        
        for (int val : A) {
            
            if (group.contains(val)) {
                group.remove(val);
            } else {
                group.add(val);
            }
        }
        
        Iterator<Integer> it = group.iterator();
        return it.next();
    }
}