class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> countFreq = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>(nums.length, Comparator.comparingInt(Pair::freq).reversed());

        for (int num : nums) {
            countFreq.merge(num, 1, Integer::sum);
        }

        countFreq.entrySet().stream()
                .map(e -> new Pair(e.getKey(), e.getValue()))
                .forEach(queue::offer);

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().num();
        }

        return result;
    }
}

record Pair(int num, int freq) {}