class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
    
        List<Integer> prefixCount = new ArrayList<>();
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);
        
        long count = 0;
        int modSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            
            modSum = (modSum + (nums.get(i) % modulo == k ? 1 : 0) + modulo) % modulo;
            
            int needed = (modSum - k + modulo) % modulo;
            if (prefixMap.containsKey(needed)) {
                count += prefixMap.get(needed);
            }
            
            prefixMap.merge(modSum, 1, Integer::sum);
       
            //System.out.println("modSum="+modSum);
            //System.out.println("count="+count);
            //System.out.println("prefix="+prefixMap);
            //System.out.println("----------");
        }
        
        return count;
    }
}