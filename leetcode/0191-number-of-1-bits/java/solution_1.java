class Solution {
    public int hammingWeight(int n) {
        
        long mask = 1;
        int count = 0;
        int shiftedBits = 0;
        while (mask <= n) {
            
            long num = n & mask;
            num = num >> shiftedBits;
            if (num == 1) {
                count++;
            }
            
            shiftedBits++;
            mask = mask << 1;
        }
        
        return count;
    }
}