class Solution {
    public int minSubarray(int[] nums, int p) {
        
        long totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }
        
        int mod = (int)(totalSum % p);
        if (mod == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixMod = new HashMap<>();
        prefixMod.put(0, -1);
        
        int sum = 0;
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % p;
            int needed = (sum - mod + p) % p;
            if (prefixMod.containsKey(needed)) {
                ans = Math.min(ans, i - prefixMod.get(needed));  
            }
            prefixMod.put(sum, i);
        }
        
        return ans == nums.length ? -1 : ans;
    }
}