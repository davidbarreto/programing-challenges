class Solution {

    private static final int INFINITY = Integer.MAX_VALUE;

    public int jump(int[] nums) {
        return jump(nums, 0, new HashMap<>());
    }

    private int jump(int[] nums, int index, Map<Integer, Integer> memo) {

        //System.out.println("[" + index + "] Starting");
        if (memo.containsKey(index)) {
            //System.out.println("[" + index + "] Returning from memo: " + memo.get(index));
            return memo.get(index);
        }

        if (index == (nums.length - 1)) {
            //System.out.println("[" + index + "] Reached last index! Return 0");
            memo.put(index, 0);
            return 0;
        }

        if (index >= nums.length || nums[index] == 0) {
            //System.out.println("[" + index + "] Index greater then len or found a 0. Return INFINITY");
            memo.put(index, INFINITY);
            return INFINITY;
        }

        int min = INFINITY;
        for (int i = nums[index]; i >= 1; i--) {
            //System.out.println("[" + index + "] Calling recursion to " + (index + i));
            min = Math.min(min, jump(nums, index + i, memo));
        }

        int result = min == INFINITY ? INFINITY : 1 + min;
        
        //System.out.println("[" + index + "] Return " + result);
        memo.put(index, result);
        return result;
    }
}