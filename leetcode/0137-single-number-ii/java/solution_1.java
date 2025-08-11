class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;

    for (int i = 0; i < 32; ++i) {
      int sum = 0;
      //System.out.printf("i=%d:\n", i);
      for (final int num : nums) {
        //System.out.printf("num=%s:\n", Integer.toBinaryString(num));
        int val = num >> i & 1;
        //System.out.printf("val=%s\n", Integer.toBinaryString(val));
        sum += val;
        //System.out.printf("loop sum=%s\n", Integer.toBinaryString(sum));
        //System.out.printf("-------\n");
      }
      sum %= 3;
      //System.out.printf("out loop sum=%s\n", Integer.toBinaryString(sum));
      ans |= sum << i;
      //System.out.printf("ans=%s\n", Integer.toBinaryString(ans));
      //System.out.printf("================\n");
    }

    return ans;
  }
}