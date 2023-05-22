import java.util.HashSet;

class Solution {
    public int solution(int X, int[] A) {
        // write your code in Java SE 8
        
        HashSet<Integer> group = new HashSet<>();
        
        for (int i = 0; i < A.length; i++) {
            
            if (!group.contains(A[i])) {
                group.add(A[i]);
            }
            
            if (group.size() == X) {
                return i;
            }
        }
        
        return -1;
    }
}