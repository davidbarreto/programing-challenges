class Solution {
    public boolean isPalindrome(String s) {
        
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
        
            char left = s.charAt(i);
            char right = s.charAt(j);
            
            while((i < (s.length() -1)) && !Character.isLetterOrDigit(left)) {
                left = s.charAt(++i);
            }
            
            while(j > 0 && !Character.isLetterOrDigit(right)) {
                right = s.charAt(--j);
            }
            
            if (i > j) {
                break;
            }
            
            //System.out.printf("i=%d, j=%d\n", i, j);
            //System.out.printf("Comparing %c and %c\n", left, right);
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}