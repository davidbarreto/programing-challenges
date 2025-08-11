class Solution {
    public int majorityElement(int[] nums) {
        
        int majoritySize = nums.length / 2;
        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.merge(n, 1, Integer::sum);
        }
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > majoritySize) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}