class Solution {
    public String reverseWords(String s) {
        
        char[] original = s.toCharArray();
        char[] ans = new char[s.length()];

        return new String(ans, 0, search(original, ans, 0));
    }

    public int search(char[] original, char[] ans, int start) {

        // Ignore spaces
        while(start < original.length && original[start] == ' ') {
            start++;
        }

        int end = start;
        while(end < original.length && original[end] != ' ') {
            end++;
        }

        if (start == end) {
            return 0;
        }

        //recursion
        int len = search(original, ans, end);
        if (len != 0) {
            ans[len++] = ' ';
        }

        while (start < end) {
            ans[len++] = original[start++];
        }

        return len;
    }
}