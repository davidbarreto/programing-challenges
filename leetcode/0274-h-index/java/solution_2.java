class Solution {
    public int hIndex(int[] citations) {
        
        if (citations.length == 1) {
            return citations[0] == 0 ? 0 : 1;
        }

        Arrays.sort(citations);
        int hIndex = citations[citations.length - 1];
        if (hIndex == 0) {
            return 0;
        }

        int count = 1;
        for (int i = citations.length - 2; i >= 0; i--) {
            //System.out.println("hIndex: " + hIndex + ", count: " + count + ", citations[" + i + "]: " + citations[i]);
            if (citations[i] == 0) {
                //System.out.println("Found 0. Breaking...");
                break;
            }

            if (count >= hIndex) {
                //System.out.println("Early end. count = " + count + ", hIndex = " + hIndex);
                return hIndex;
            }

            if (count > citations[i]) {
                //System.out.println("Early end. count = " + count + ", citations[" + i + "]: " + citations[i]);
                return count;
            }

            if (citations[i] != hIndex) {
                hIndex = citations[i];
            }
            count++;
        }

        //System.out.println("Out of for loop. count = " + count + ", hIndex = " + hIndex);
        return Math.min(count, hIndex);
    }
}