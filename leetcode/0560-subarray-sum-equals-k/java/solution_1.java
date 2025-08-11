class Solution {
    public int subarraySum(int[] nums, int k) {
    
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //System.out.println("sum="+sum);
         
            int diff = sum - k;
            if (prefixMap.containsKey(diff)) {
                count += prefixMap.get(diff);
            }
            
            prefixMap.merge(sum, 1, Integer::sum);
            //System.out.println("count="+count);
            //System.out.println(prefixMap);
            //System.out.println("---------");
        }
        
        return count;
    }
}