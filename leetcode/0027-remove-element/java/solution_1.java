class Solution {
    public int removeElement(int[] nums, int val) {
        
        int k = nums.length - 1;
        int i = 0;
        k = advanceK(nums, val, k);
        
        while (i < k) {
            //System.out.printf("i=%d k=%d\n", i, k);
            //print(nums);
            if (nums[i] == val) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                k--;
                k = advanceK(nums, val, k);
            }
            i++;
        }
        
        //print(nums);
        return k+1;
    }
    
    private void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("a[%d]=%d ", i, nums[i]);
        }
        System.out.println();
    }
    
    private int advanceK(int[] nums, int val, int k) {
        while(k >= 0 && nums[k] == val) {
            k--;
        }
        //System.out.printf("k advanced to %d\n", k);
        return k;
    }
}