class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return wordBreak(s, 0, wordDict, memo);
    }

    private boolean wordBreak(String s, int index, List<String> wordDict, Boolean[] memo) {
        
        if (index == s.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        boolean res = false;
        for (String word : wordDict) {
            if (s.startsWith(word, index)) {
                res |= wordBreak(s, index + word.length(), wordDict, memo);
            }
        }

        memo[index] = res;
        return res;
    }
}