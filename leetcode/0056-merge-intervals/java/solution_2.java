/**
 * This version improves solution 1 in the following items:
 * 1. Boxing (I was using List<List<Integer>> as result, so I necesserally had to box the integers all the time in the loop
 * 2. The second condition on sort comparator is not necessary (all depends on the start only)
 *
 * Runtime: 8 ms
 * Memory: 49.2 MB
 */
class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];

        List<int[]> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);

                // No Overlap
            } else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}