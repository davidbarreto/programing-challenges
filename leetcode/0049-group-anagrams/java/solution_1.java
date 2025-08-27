class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<CharKey, List<String>> map = new HashMap<>();

        for (String word : strs) {
            CharKey key = new CharKey();
            for (int i = 0; i < word.length(); i++) {
                key.chars.merge(word.charAt(i), 1, Integer::sum);
            }
            map.computeIfAbsent(key, a -> new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> words : map.values()) {
            result.add(words);
        }

        return result;
    }

    class CharKey {
        Map<Character, Integer> chars = new HashMap<>();

        @Override
        public int hashCode() {
            return chars.hashCode();
        }

        @Override
        public boolean equals(Object other) {

            if (this == other) {
                return true;
            }

            if (other == null) {
                return false;
            }

            if (!(other instanceof CharKey)) {
                return false;
            }
            return chars.equals(((CharKey)other).chars);
        }

        @Override
        public String toString() {
            return chars.toString();
        }
    }
}