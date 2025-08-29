class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Integer> uniqueInts = populate(nums);
        int longest = 0;
        int current = 0;

        // Supose num is the last number of a sequence
        for (Integer num : uniqueInts.keySet()) {

            if (uniqueInts.get(num) == 0) {
                // Already handled, so there is an element before ie. longer sequence
                continue;
            }

            current = 1;
            int next = num+1;

            // If we have a immediate predecessor...
            while (uniqueInts.containsKey(next)) {
                int count = uniqueInts.get(next);
                if (count > 0) {
                    current += count;
                    break;
                }

                uniqueInts.put(next, 0);
                current++;
                next++;                
            }

            uniqueInts.put(num, current);
            if (current > longest) {
                longest = current;
            }
        }

        return longest;
    }

    private Map<Integer, Integer> populate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, -1);
        }
        return map;
    }
}