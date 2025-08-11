class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        Map<Character, String> map = new HashMap<>();
        Set<String> mapped = new HashSet<>();
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        for (int i = 0; i < pattern.length(); i++) {
            
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (mapped.contains(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
                mapped.add(words[i]);
            }
        }
        
        return true;
    }
}