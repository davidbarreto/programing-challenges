class Solution {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }
    
    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n <= 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int res = climbStairs(n-1, memo) + climbStairs(n-2, memo);
        memo.put(n, res);
        return res;
    }
}