class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, wordDict, new HashMap<>());
    }

    private boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> memo) {
        
        if (s.isEmpty()) {
            return true;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        boolean res = false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                res |= wordBreak(s.substring(word.length()), wordDict, memo);
            }
        }

        memo.put(s, res);
        return res;
    }
}