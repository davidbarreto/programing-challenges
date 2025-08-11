class Solution {
    public int removeDuplicates(int[] nums) {
        int place = 0;
        int i = 0;

        while (i < nums.length) {
            nums[place++] = nums[i];
            int count = 1;
            int j = i + 1;

            while (j < nums.length && nums[i] == nums[j]) {
                count++;
                if (count <= 2) {
                    nums[place++] = nums[j];
                }
                j++;
            }

            i = j; // move to the next new number
        }

        return place;
    }
}