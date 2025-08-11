class Solution {
    
    public int mySqrt(int x) {
        
        if (x == 0) {
            return 0;
        }
        
        long count = 1;
        long square = count;
        int ans = 0;
        do {
            ans = (int) count;
            count++;
            square = count * count;
        } while (square <= x);
        
        return ans;
    }
}