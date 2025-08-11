class Solution {
    public List<String> summaryRanges(int[] nums) {
        
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        
        int size = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            
            if (nums[i]+1 != nums[i+1]) {
                int left = nums[i-size+1];
                if (size == 1) {
                    ans.add(String.valueOf(left));
                } else {
                    ans.add(left + "->" + nums[i]);
                }
                size = 1;
            } else {
                size++;
            }
        }
        
        int left = nums[nums.length-1-size+1];
        if (size == 1) {
            ans.add(String.valueOf(left));    
        } else {
            ans.add(left + "->" + nums[nums.length-1]);
        }
        
        return ans;
    }
}