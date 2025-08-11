class Solution {
    public boolean isPalindrome(int x) {
        
        if (x < 0) {
            return false;
        }
        
        int reversed = 0;
        int n = x;
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            
            reversed *= 10;
            reversed += digit;
        }
        
        return x == reversed;
    }
}