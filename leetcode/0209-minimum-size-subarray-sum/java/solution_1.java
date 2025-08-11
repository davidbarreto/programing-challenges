class Solution {
    public int minSubArrayLen(int target, int[] nums) {
     
        int start = 0;
        int end = 0;
        
        int len = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length) {
            
            sum += nums[end];
            if (sum >= target) {
                
                while(sum >= target) {
                    sum -= nums[start];
                    start++;
                }
                
                len = Math.min(len, (end-start+2));
            }
            end++;
        }
        
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}