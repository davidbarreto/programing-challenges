class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            Integer[] mapping = new Integer[26];
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i)-'a';
                if (mapping[index] == null) {
                    mapping[index] = 1;
                } else {
                    mapping[index]++;
                }
            }
            map.computeIfAbsent(Arrays.asList(mapping), a -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}