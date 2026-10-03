/**
 * Hash map + priority queue.
 * Let n = words.length, u = number of unique words (u <= n, k <= u).
 *
 * Time:
 * - Count frequencies with a hash map: O(n)
 * - Build the list of Word objects: O(u)
 * - Build the priority queue from the collection (heapify): O(u)
 * - Poll k elements: O(k log u)
 * Total: O(n + k log u)
 *
 * Space:
 * - Hash map, Word list, priority queue: O(u) each
 * - Answer list: O(k)
 * Total: O(u)
 *
 * (Assumes string hashing/comparison is O(1); with max word length L,
 * multiply the terms by L.)
 *
 * Runtime: 6ms
 * Memory: 46.65 MB
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.merge(word, 1, Integer::sum);
        }

        List<Word> uniqueWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            uniqueWords.add(new Word(entry.getKey(), entry.getValue()));
        }

        PriorityQueue<Word> queue = new PriorityQueue<>(uniqueWords);

        List<String> ans = new ArrayList<>();
        while(k-- > 0) {
            ans.add(queue.poll().str());
        }

        return ans;
    }

    record Word(String str, int freq) implements Comparable<Word> {
        public int compareTo(Word other) {
            var intComp = Integer.compare(other.freq(), this.freq());
            return intComp == 0 ? this.str().compareTo(other.str()) : intComp;
        }
    }
}