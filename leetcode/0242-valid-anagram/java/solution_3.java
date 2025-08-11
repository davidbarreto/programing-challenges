class Solution {
    public boolean isAnagram(String s, String t) {
        
        Map<Character, Integer> sFreq = countFrequence(s);
        Map<Character, Integer> tFreq = countFrequence(t);
        
        return sFreq.equals(tFreq);
    }
    
    private Map<Character, Integer> countFrequence(String word) {
        
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            freq.merge(word.charAt(i), 1, Integer::sum);
        }
        
        return freq;
    }
}