class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> map = new HashMap<>();

        for (String word : strs) {

            Integer key = hash(word);
            //System.out.println("hashcode for " + word + " = " + key);
            map.computeIfAbsent(key, a -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    private int hash(String word) {

        int hash = 0;
        for (int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
            hash += ch * ch * ch * ch;
        }

        return hash;
    }
}