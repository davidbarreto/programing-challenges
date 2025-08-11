class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int countDuplicates = 0;
        int num = nums[0];
        int duplicatesRemovedCount = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                countDuplicates++;
                if (countDuplicates >= 2) {
                    nums[i] = Integer.MAX_VALUE;
                    duplicatesRemovedCount++;
                }
            } else {
                num = nums[i];
                countDuplicates = 0;
            }
        }

        Arrays.sort(nums);
        return nums.length - duplicatesRemovedCount;     
    }
}