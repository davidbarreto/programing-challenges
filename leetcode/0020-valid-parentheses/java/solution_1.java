class Solution {
    public boolean isValid(String s) {
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            
            if (isOpenningBracket(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.peek();
                if (isCorrespondingClosingBracket(top, c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isOpenningBracket(char c) {
        return (c == '[' || c == '(' || c == '{');
    }
    
    private boolean isCorrespondingClosingBracket(char begin, char end) {
        return ((begin == '(' && end == ')') ||
                (begin == '[' && end == ']') ||
                (begin == '{' && end == '}'));
    }
}