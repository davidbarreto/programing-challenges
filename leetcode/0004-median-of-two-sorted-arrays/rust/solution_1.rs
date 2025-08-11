impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        
        let n = nums1.len();
        let m = nums2.len();
        let s = n + m;

        let mut dest = vec![0; s];

        let mut i: usize = 0;
        let mut j: usize = 0;
        let mut k: usize = 0;
        
        while i < n && j < m {
            if nums1[i] < nums2[j] {
                dest[k] = nums1[i];
                i += 1;
            } else {
                dest[k] = nums2[j];
                j += 1;
            }
            k += 1;
        }

        while i < n {
            dest[k] = nums1[i];
            i += 1;
            k += 1;
        }

        while j < m {
            dest[k] = nums2[j];
            j += 1;
            k += 1;
        }

        let middle = s / 2 as usize;
        if s % 2 != 0 {
            return dest[middle] as f64;
        } else {
            return (dest[middle] + dest[middle-1]) as f64 / 2.0;
        }

    }
}