class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> characterCount = new HashMap<>();
        for (char ch : ransomNote.toCharArray()) {
            characterCount.merge(ch, 1, Integer::sum);
        }
        
        for (char ch : magazine.toCharArray()) {
            if (characterCount.containsKey(ch)) {
                int count = characterCount.get(ch);
                if (count == 1) {
                    characterCount.remove(ch);
                } else {
                    characterCount.put(ch, count-1);
                }
            }
        }
        
        return characterCount.isEmpty();
    }
}