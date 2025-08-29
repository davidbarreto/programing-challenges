class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> seen = new HashSet<>(nums.length);
        for (int num : nums) {
            seen.add(num);
        }

        int longestSequence = 0;
        for (Integer num : seen) {

            if (seen.contains(num-1)) {
                // num is inside a sequence. Ignore and check next element
                continue;
            }

            int sequenceSize = 1;
            while (seen.contains(num + sequenceSize)) {
                sequenceSize++;           
            }

            longestSequence = Math.max(longestSequence, sequenceSize);
        }

        return longestSequence;
    }
}