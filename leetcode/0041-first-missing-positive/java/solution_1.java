class Solution {
    public int firstMissingPositive(int[] nums) {
        
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int x = nums[i];
            if (x > 0 && x <= n && nums[x-1] != x) {
                swap(nums, x-1, i);
            } else {
                i++;
            }
        }
        
        for (i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        
        return n + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}