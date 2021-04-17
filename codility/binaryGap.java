// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int N) {
    
        int number = N;
        int digit = number & 1;
        int count = 0;
        int maxGap = 0;
        
        //ignore the first zeros
        while(digit == 0) {
            number = number >> 1;
            digit = number & 1;
        }
        
        while (number != 0 ) {

            if (digit == 1) {
                
                if (count > maxGap) {
                    maxGap = count;
                }
                
                count = 0;
            }
            
            //ignore a bunch of ones
            while(digit == 1) {
                number = number >> 1;
                digit = number & 1;
            }
            
            count++;
            
            number = number >> 1;
            digit = number & 1;
        }
        
        return maxGap;
    }
}