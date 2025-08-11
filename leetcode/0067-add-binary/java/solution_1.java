class Solution {
    public String addBinary(String a, String b) {
        
        int indA = a.length() - 1;
        int indB = b.length() - 1;
        
        StringBuilder ans = new StringBuilder();
        int rest = 0;
        while(indA >= 0 || indB >= 0) {

            int bitA = indA >= 0 ? a.charAt(indA) - '0' : 0;
            int bitB = indB >= 0 ? b.charAt(indB) - '0' : 0;
            int sum = bitA + bitB + rest;
            int bit = sum % 2;
            ans.insert(0, bit);
            rest = sum / 2;
            //System.out.printf("a[%d] = %d, b[%d] = %d, sum = %d. Bit = %d and rest = %d \n", indA, bitA, indB, bitB, sum, bit, rest);
            indA--;
            indB--;
        }
        
        if (rest == 1) {
            ans.insert(0, 1);
        }
        
        //System.out.println("ans="+ans.toString());
        return ans.toString();
    }
}