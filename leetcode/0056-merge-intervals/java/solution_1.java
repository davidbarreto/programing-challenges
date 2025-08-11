class Solution {
    public int[][] merge(int[][] intervals) {
        
        if (intervals.length == 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a1,a2) -> (a1[0] - a2[0]) == 0 ? (a1[1] - a2[1]) : (a1[0] - a2[0]));
        //System.out.println(Arrays.deepToString(intervals));
        
        List<List<Integer>> result = new ArrayList<>();
        
        int i = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
        while(i < intervals.length) {
            
            int s = intervals[i][0];
            int e = intervals[i][1];
            
            //System.out.printf("i=%d, start=%d, end=%d, s=%d, e=%d\n", i, start, end, s, e);
            
            if (end >= s) {
                
                end = Math.max(end, e);
                
                i++;
                continue;
            }
            
            //System.out.printf("Adding [%d,%d]\n", start, end);
            result.add(List.of(start, end));
            
            start = s;
            end = e;
            
            i++;
        }
        
        result.add(List.of(start, end));
        //System.out.println("Current result: " + result);
        
        int[][] ans = new int[result.size()][2];
        int j = 0;
        for (List<Integer> r : result) {
            ans[j][0] = r.get(0);
            ans[j][1] = r.get(1);
            j++;
        }
        
        return ans;
    }
}