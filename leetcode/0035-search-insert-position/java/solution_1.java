class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length - 1;
        int mid = nums.length / 2;
        while (start <= end) {
            int curr = nums[mid];
            if (curr == target) {
                return mid;
            } else if (curr < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            mid = start + (end-start) / 2;
        }
        
        return mid;
    }
}