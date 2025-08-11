class Solution {
    public void rotate(int[] nums, int k) {
        
        if (k % nums.length == 0) {
            return;
        }
        
        int[] copy = Arrays.copyOf(nums, nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            int index = (i + k) % nums.length;
            nums[index] = copy[i];
        }
    }
}