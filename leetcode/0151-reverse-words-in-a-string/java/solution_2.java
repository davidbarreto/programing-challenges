class Solution {
    public String reverseWords(String s) {
        
        StringBuilder ans = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean isEndOfWord = false;
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                isEndOfWord = true;
                continue;
            }

            if (isEndOfWord && !word.isEmpty()) {
                word.append(" ");
                ans.insert(0, word);
                word = new StringBuilder();
            }
            word.append(ch);
            isEndOfWord = false;
        }

        if (!word.isEmpty()) {
            word.append(" ");
            System.out.println("last word: " + word.toString());
            ans.insert(0, word);
        }

        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}