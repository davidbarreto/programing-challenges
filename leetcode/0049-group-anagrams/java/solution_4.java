class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] wordChars = word.toCharArray();
            Arrays.sort(wordChars);
            String key = new String(wordChars);
            map.computeIfAbsent(key, a -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}