/*
2 3 1 7 1 -> 0

+2+3+1+7
*/
class Solution {
    
    public int findTargetSumWays(int[] nums, int target) {
        return calculate(nums, 0, 0, target, new HashMap<String, Integer>());   
    }
    
    private int calculate(int[] nums, int i, int sum, int target, Map<String, Integer> mem) {
        
        int result;
        String key = i + ";" + sum;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }
        
        if (i == nums.length) {
            result = (sum == target) ? 1 : 0;
        } else {
            int add = calculate(nums, i + 1, sum + nums[i], target, mem);
            int sub = calculate(nums, i + 1, sum - nums[i], target, mem);
            
            result = add + sub;
        }
        
        mem.put(key, result);
        return result;
    }
}