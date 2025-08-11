class Solution {
    public int[] plusOne(int[] digits) {
     
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        int[] ans = digits;
        if (carry > 0) {
            ans = new int[digits.length + 1];
            ans[0] = carry;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i-1];
            }
        }
        
        return ans;
    }
}