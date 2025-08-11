class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            
            //System.out.println("sum="+sum);
            //System.out.println("mod="+mod);
            
            if (prefixSum.containsKey(mod)) {
                count += prefixSum.get(mod);
            }
            prefixSum.merge(mod, 1, Integer::sum);
            
            //System.out.println("count="+count);
            //System.out.println("prefix="+prefixSum);
            //System.out.println("----------");
        }
        
        return count;
    }
}