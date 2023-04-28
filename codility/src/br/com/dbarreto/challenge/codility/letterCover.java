// you can also use imports, for example:
 import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String P, String Q) {
        
        int len = P.length();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char chP = P.charAt(i);
            char chQ = Q.charAt(i);

            freqMap.merge(chP, 1, Integer::sum);
            freqMap.merge(chQ, 1, Integer::sum);
        }

        System.out.println(freqMap);
        List<Integer> ties = new ArrayList<>();
        Set<Character> uniqueChosenChars = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char chP = P.charAt(i);
            char chQ = Q.charAt(i);

            int freqChP = freqMap.get(chP);
            int freqChQ = freqMap.get(chQ);

            if (freqChP > freqChQ) {
                uniqueChosenChars.add(chP);
            } else if (freqChP < freqChQ){
                uniqueChosenChars.add(chQ);
            } else {
                ties.add(i);
            }
        }

        for (int i : ties) {
            char chP = P.charAt(i);
            char chQ = Q.charAt(i);

            if (!uniqueChosenChars.contains(chP) && !uniqueChosenChars.contains(chQ)) {
                uniqueChosenChars.add(chP);
            }
        }

        return uniqueChosenChars.size();
    }
}
