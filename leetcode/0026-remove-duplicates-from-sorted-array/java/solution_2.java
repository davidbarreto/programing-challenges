class Solution {
    public int removeDuplicates(int[] nums) {
    
        int k = 0;
        Set<Integer> mem = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (mem.contains(nums[i])) {
                nums[i] = Integer.MAX_VALUE;
                k++;
            } else {
                mem.add(nums[i]);
            }
        }
        
        Arrays.sort(nums);
        
        return nums.length - k;
    }
}