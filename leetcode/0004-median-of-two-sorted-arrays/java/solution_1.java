class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int s = n + m;

        int [] dest = new int[s];

        int i = 0;
        int j = 0;
        int k = 0;
        while (k < s && i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                dest[k++] = nums1[i++];
            } else {
                dest[k++] = nums2[j++];
            }
        }

        while (i < n) {
            dest[k++] = nums1[i++];
        }

        while (j < m) {
            dest[k++] = nums2[j++];
        }

        int middle = s / 2;

        if (s % 2 == 0) {
            return (dest[middle] + dest[middle-1]) / 2.0;
        } else {
            return dest[middle];
        }
    }
}