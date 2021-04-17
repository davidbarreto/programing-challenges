import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        
        if (A.length == 0) {
            return 1;
        }
        
        HashSet<Integer> group = new HashSet<>();
        for (int i = 1; i <= A.length + 1; i++) {
            group.add(i);
        }
        
        for (int i = 0; i < A.length; i++) {
            group.remove(A[i]);   
        }
        
        Iterator<Integer> it = group.iterator();
        return it.next();
    }
}