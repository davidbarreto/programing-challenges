class Solution {
    public String decodeString(String s) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            
            char curr = s.charAt(i);
            if (curr == ']') {      
            
                //Find the string to be repeated
                StringBuilder string = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '[') {
                    string.insert(0, stack.pop());
                }
                
                //Remove '['
                stack.pop();
                
                //Find the repeat count
                StringBuilder repeatCount = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    repeatCount.insert(0, stack.pop());
                }
                     
                int count = Integer.parseInt(repeatCount.toString());
                String repeatedString = string.toString().repeat(count);
                for (char c : repeatedString.toCharArray()) {
                    stack.push(c);
                }
                
            } else {
                stack.push(curr);
            }
        }
                      
                      
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        
        return ans.toString();
    }
}