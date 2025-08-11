class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if (s.isEmpty()) {
            return true;
        }
        
        if (t.isEmpty()) {
            return false;
        }
        
        int idx = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(idx)) {
                idx++;
            }
            if (idx == s.length()) {
                break;
            }
        }
        return idx == s.length();
    }
}