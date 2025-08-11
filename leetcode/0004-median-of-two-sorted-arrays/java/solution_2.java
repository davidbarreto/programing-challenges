class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0 && m == 0) {
            return 0.0;
        }

        int[] ans;
        if (n == 0) {
            ans = nums2;
        } else if (m == 0) {
            ans = nums1;
        } else {
            ans = new int[n + m];
            fill(ans, nums1, 0);
            fill(ans, nums2, n);
            Arrays.sort(ans);
        }

        int k = ans.length;
        int middle = k / 2;
        if (k % 2 == 0) {
            return (((double) ans[middle]) + ans[middle-1]) / 2.0;
        } else {
            return (double) ans[middle];
        }
    }

    private void fill(int[] dest, int[] ori, int start) {
        for (int i = start; i < (start + ori.length); i++) {
            dest[i] = ori[i - start];
        }
    }
}