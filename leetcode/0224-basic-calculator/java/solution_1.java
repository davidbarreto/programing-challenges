class Solution {
    public int calculate(String s) {
        
        int ans = 0;
        Deque<StringBuilder> expression = new ArrayDeque<>();
        StringBuilder latest = new StringBuilder();
        for (char c : s.toCharArray()) {
        
            if (c == ' ') {
                continue;
            }
            
            if (c == '(') {
                if (!latest.isEmpty()) {
                    expression.push(latest);    
                    latest = new StringBuilder();
                }
            } else if (c == ')') {
                StringBuilder evaluated = evaluate(latest);
                StringBuilder top = !expression.isEmpty() ? expression.pop() : new StringBuilder();
                latest = top.append(evaluated);
            } else {
                latest.append(c);    
            }
            
            //System.out.printf("Latest [%s]\n", latest.toString());
        }
        
        //System.out.println(latest.toString());
        
        return Integer.parseInt(evaluate(latest).toString());
    }
    
    private StringBuilder evaluate(StringBuilder expression) {
        
        int ans = 0;
        char op = '+';
        StringBuilder latestNum = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '+' || c == '-') {
                ans += acumulate(op, latestNum);
                op = updateOperation(op, c, expression, i);
                latestNum = new StringBuilder();
                //System.out.printf("ans [%d], current op [%c]\n", ans, op);
            } else {
                latestNum.append(c);
            }
        }
        
        if (!latestNum.isEmpty()) {
            ans += acumulate(op, latestNum);
        }
        
        //System.out.printf("Expression [%s] evaluated to [%d]\n", expression.toString(), ans);
        return new StringBuilder(String.valueOf(ans));
    }
    
    private int acumulate(char op, StringBuilder latestNum) {
        int num = latestNum.isEmpty() ? 0 : Integer.parseInt(latestNum.toString());
        //System.out.printf("Num [%d], Op [%c]\n", num, op);

        int calc = (op == '+' ? num : -num);
        //System.out.printf("calc [%d]\n", calc);
        return calc;
    }
    
    private char updateOperation(char op, char c, StringBuilder expression, int i) {
        if (i > 0 && expression.charAt(i-1) == '-' && c == '-') {
            return '+';
        } 
        return c;
    }
}