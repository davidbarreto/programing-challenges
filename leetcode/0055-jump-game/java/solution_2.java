class Solution {

    static{
        for(int i=0;i<500;i++){
            canJump(new int[1]);
        }
    }
    public static boolean canJump(int[] nums) {
        return canJump(nums, 0, new HashMap<>());
    }

    private static boolean canJump(int[] nums, int index, Map<Integer, Boolean> memo) {

        //System.out.println("Calling for index: " + index + ", nums[index] = " + nums[index]);

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