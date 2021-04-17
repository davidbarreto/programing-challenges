// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class Solution {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        
		int MAX = N+1;
        int[] B = new int[N];
        HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
        
        //System.out.println("MAXCOUNTER = " + MAX);

        for (int i=0; i < A.length; i++) {
            //System.out.println("A[" + i + "] = " + A[i]);
            if (A[i] == MAX) {
				list.add(map);
                map = new HashMap<Integer, Integer>();
            } else {
                int val = 1;
                if (map.containsKey(A[i])) {
                    val = map.get(A[i]);
                    val++;
                }
                
                map.put(A[i], val);
                //System.out.println("VAL FOR " + A[i] + " = " + val);
            }
        }
		
		int base = getBase(list);
        
        for (int i=0; i<N; i++) {

            Integer val = map.get(i+1);
            B[i] = base + (val == null ? 0 : val); 
        }
        
        return B;
    }
    
    private int getBase(ArrayList<HashMap<Integer, Integer>> list) {

		int base = 0;
		for (HashMap<Integer, Integer> map : list) {
			int maxCounter = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int value = entry.getValue();
				if (value > maxCounter) {
					maxCounter = value;
				}
			}
			base += maxCounter;
		}
		
		//System.out.println("MAX = " + maxCounter);
		return base;
    }
}