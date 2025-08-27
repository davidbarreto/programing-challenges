class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String word : strs) {
            List<Integer> mapping = createEmptyList();
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i)-'a';
                mapping.set(index, mapping.get(index)+1);
            }
            map.computeIfAbsent(mapping, a -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }

    private List<Integer> createEmptyList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(0);
        }

        return list;
    }
}