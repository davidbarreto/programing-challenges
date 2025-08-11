class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : nums) {
            queue.add(i);
        }
        
        int ans = 0;
        while(k-- > 0) {
            ans = queue.poll();
        }
        
        return ans;
    }
}