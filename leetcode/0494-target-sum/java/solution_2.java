/*
2 3 1 7 1 -> 0

+2+3+1+7
*/
class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target);   
    }
    
    private int calculate(int[] nums, int i, int sum, int target) {
        
        if (i == nums.length) {
            return (sum == target) ? 1 : 0;
        } else {
            int add = calculate(nums, i + 1, sum + nums[i], target);
            int sub = calculate(nums, i + 1, sum - nums[i], target);
            
            return add + sub;
        }
    }
}