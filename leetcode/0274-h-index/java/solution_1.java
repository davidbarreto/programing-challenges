class Solution {
    public int hIndex(int[] citations) {
        
        int count = 0;
        int n = citations.length;
        Arrays.sort(citations);

        for (int i = n-1; i >= 0; i--) {
            if (citations[i] >= n - i) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}