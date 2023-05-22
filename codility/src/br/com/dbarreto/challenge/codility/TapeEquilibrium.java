package br.com.dbarreto.challenge.codility;

class TapeEquilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8
    
        int sum = 0;
        for (int val : A) {
            sum += val;
        }
        
        int diffSum = 0;
        int min = 2147483647;
        
        for (int i = 0; i < A.length - 1; i++) {
            diffSum += A[i];
            
            int diffRight = sum - diffSum;
            int diffLeft = diffSum;
            
            int diffLocal = diffLeft - diffRight;
            
            if (diffLocal < 0) {
                diffLocal = -diffLocal;
            }
        
            if (diffLocal < min) {
                min = diffLocal;
            }
        }
        
        return min;
    }
}