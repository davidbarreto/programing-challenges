class Solution {
    public int[] solution(int[] A, int K) {
        
        int len  = A.length;
		
		//I forgot to handle the empty-array test case during the test.
		//Without the condition above, the mod function causes an error
		//(Division by zero)
		if (len == 0) {
			return A;
		}
		
        int jump = K % len;
        
        if (jump == 0) {
            return A;
        }
        
        int[] B = new int[len];
        
        for (int i = 0; i < len; i++) {
            B[(i+jump) % len] = A[i];
        }
        
        return B;
    }
}