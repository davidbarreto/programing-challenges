class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];
        Map<Integer, Integer> countFreq = new HashMap<>();

        for (int num : nums) {
            countFreq.merge(num, 1, Integer::sum);
        }

        List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(countFreq.entrySet());
        sorted.sort(Map.Entry.comparingByValue());

        int i = sorted.size() - 1;
        int j = 0;
        int num = sorted.get(i).getKey();
        while (k-- > 0) {
            result[j++] = sorted.get(i).getKey();
            while (i > 0 && (num == sorted.get(i).getKey())) {
                i--;
            }
            num = sorted.get(i).getKey();
        }
        return result;
    }
}