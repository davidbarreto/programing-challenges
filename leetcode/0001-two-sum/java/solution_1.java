class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = target - nums[i];
            if (seen.containsKey(pair)) {
                int pairIndex = seen.get(pair);
                result[0] = pairIndex;
                result[1] = i;
                return result;
            }
            seen.put(nums[i], i);
        }

        return result;
    }
}