class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, wordDict, new HashMap<>());
    }

    private boolean wordBreak(String s, int index, List<String> wordDict, Map<Integer, Boolean> memo) {
        
        if (index == s.length()) {
            return true;
        }

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        boolean res = false;
        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                res |= wordBreak(s, index + word.length(), wordDict, memo);
            }
        }

        memo.put(index, res);
        return res;
    }
}