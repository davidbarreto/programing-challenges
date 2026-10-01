/**
 * Solution using a Binary Search
 * For each prefix, find the first product that is greater than or equal to the prefix, using a lower bound Binary Search
 * Check up to 3 next products using a startsWith method.
 * As it's a Binary Search algorithm, the input needs to be sorted, so I sorted products first in order to make it work
 */
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>(searchWord.length());

        int lo = 0;
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            lo = lowerBound(products, lo, prefix);

            List<String> top = new ArrayList<>(3);
            for (int j = lo; j < products.length && j < lo + 3; j++) {
                if (!products[j].startsWith(prefix)) break;
                top.add(products[j]);
            }
            ans.add(top);
        }
        return ans;
    }

    // First index in [from, n) with products[idx] >= key
    private int lowerBound(String[] products, int from, String key) {
        int lo = from;
        int hi = products.length;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (products[mid].compareTo(key) < 0) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}