class Solution {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        if (nums.length == 2) {
            return nums[0] > 0;
        }

        return canJump(nums, 0, new HashMap<>());
    }

    private boolean canJump(int[] nums, int index, Map<Integer, Boolean> memo) {

        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        if (index >= (nums.length - 1)) {
            memo.put(index, true);
            return true;
        }

        if (nums[index] == 0) {
            memo.put(index, false);
            return false;
        }

        for (int i = nums[index]; i >= 1; i--) {
            if (canJump(nums, index + i, memo)) {
                memo.put(index, true);
                return true;
            }
        }
        
        memo.put(index, false);
        return false;
    }
}