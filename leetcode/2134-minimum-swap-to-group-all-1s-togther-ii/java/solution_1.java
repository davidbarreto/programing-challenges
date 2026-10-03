/**
 * Given k = total number of 1s in the array
 * and w = k-element window with most 1s
 * So the number of swaps is k-w
 *
 * Runtime: 4 ms
 * Memory: 90.61 MB
 */
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int k = 0;
        for (int x : nums) k += x;
        if (k == 0) return 0;

        int onesInWindow = 0;
        for (int i = 0; i < k; i++) onesInWindow += nums[i];

        int best = onesInWindow;
        for (int i = k; i < n + k; i++) {
            onesInWindow += nums[i % n] - nums[(i - k) % n];
            best = Math.max(best, onesInWindow);
        }
        return k - best;
    }
}