class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int max = 1;
        int count = 0;
        int lastRepeatingCharIndex = 0;
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!seen.containsKey(ch)) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }

                lastRepeatingCharIndex = Math.max(seen.get(ch), lastRepeatingCharIndex);
                count = i - lastRepeatingCharIndex;
            }
            seen.put(ch, i);
        }

        return Math.max(count, max);
    }
}