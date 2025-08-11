class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        Deque<List<Long>> deque = new ArrayDeque<>();
        long sum = 0L;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= k) {
                len = Math.min(len, i+1);
            }
            
            List<Long> curr = null;
            while (!deque.isEmpty() && (sum - deque.getFirst().get(1) >= k)) {
                curr = deque.removeFirst();
            }
            
            if (curr != null) {
                len = Math.min(len, (i - curr.get(0).intValue()));
            }
            
            while (!deque.isEmpty() && sum <= deque.getLast().get(1)) {
                deque.removeLast();
            }
            deque.addLast(Arrays.asList(Long.valueOf(i), sum));
        }
        
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}