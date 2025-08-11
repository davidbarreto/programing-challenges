class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if (n == 0) {
            return;
        }
        
        int[] ans = new int[m+n];
    
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            
            if (nums1[i] <= nums2[j]) {
                ans[k++] = nums1[i];
                i++;
            } else {
                ans[k++] = nums2[j];
                j++;
            }
        }
        
        while(i < m) {
            ans[k++] = nums1[i];
            i++;
        }

        while(j < n) {
            ans[k++] = nums2[j];
            j++;
        }
        
        for (i=0; i < ans.length; i++) {
            nums1[i] = ans[i];
        }
    }
}