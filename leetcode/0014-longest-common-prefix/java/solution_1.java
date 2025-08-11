class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        StringBuilder sb = new StringBuilder();
        int minLen = minStringLen(strs);
        for (int i = 0; i < minLen; i++) {
            if (sameChar(strs, i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }
    
    private int minStringLen(String[] strs) {
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min) {
                min = strs[i].length();
            }
        }
        return min;
    }
    
    private boolean sameChar(String[] strs, int pos) {
        char target = strs[0].charAt(pos);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].charAt(pos) != target)
                return false;
        }
        return true;
    }
}