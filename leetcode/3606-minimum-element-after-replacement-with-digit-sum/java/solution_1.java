class Solution {
    public int minElement(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n == 1) {
                return 1;
            }
            int transformed = transform(n);
            if (transformed == 1) {
                return 1;
            }

            if (transformed < min) {
                min = transformed;
            }
        }

        return min;
    }

    private int transform(int n) {

        int div = n;
        int sum = 0;
        while (div != 0) {
            int mod = div % 10;
            div /= 10;
            sum += mod;
        }
        return sum;
    }
}