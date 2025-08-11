class Solution {
    public String decodeString(String s) {
        
        ArrayDeque<StringBuilder> stackString = new ArrayDeque<>();
        ArrayDeque<Integer> stackCount = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        int n = 0;
        
        for (int i = 0; i < s.length(); i++) {
            
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                n = (n * 10) + (curr - '0');
            } else if (curr == '[') {
                stackCount.push(n);
                stackString.push(ans);
                n = 0;
                ans = new StringBuilder();
            } else if (curr == ']') {
                
                int count = stackCount.pop();
                StringBuilder string = stackString.pop();
                for (int j = 0; j < count; j++) {
                    string.append(ans);
                }
                
                ans = string;
            } else {
                ans.append(curr);
            }   
        }
        
        return ans.toString();
    }
}