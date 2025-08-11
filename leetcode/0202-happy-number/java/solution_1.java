class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();
        int result = n;
        while (result != 1 && !seen.contains(result)) {
            
            //System.out.printf("processing %d:\n", result);
            //System.out.printf("seen %s\n", seen.toString());
            seen.add(result);
            int sum = 0;
            while (result != 0) {
                
                int mod = result % 10;
                sum += (mod * mod);
                //System.out.printf("digit=%d, square=%d, sum=%d\n", mod, (mod * mod), sum);
                result /= 10;
            }
            
            result = sum;
        }   
        
        return result == 1;
    }
}