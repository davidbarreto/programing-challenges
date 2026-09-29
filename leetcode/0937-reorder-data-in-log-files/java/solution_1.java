class Solution {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> logsComparator = (a, b) -> compareLogs(a, b);
        Arrays.sort(logs, logsComparator);
        return logs;
    }

    public int compareLogs(String a, String b) {

        boolean aIsDigit = Character.isDigit(a.charAt(a.length() - 1));
        boolean bIsDigit = Character.isDigit(b.charAt(b.length() - 1));

        if (aIsDigit && !bIsDigit) {
            return 1;
        }

        if (!aIsDigit && bIsDigit) {
            return -1;
        }

        if (aIsDigit && bIsDigit) {
            return 0;
        }

        int aContentIndex = a.indexOf(' ');
        int bContentIndex = b.indexOf(' ');

        String aContent = a.substring(aContentIndex + 1);
        String bContent = b.substring(bContentIndex + 1);

        int compareContent = aContent.compareTo(bContent);

        if (compareContent == 0) {
            String aIdentifier = a.substring(0, aContentIndex);
            String bIdentifier = b.substring(0, bContentIndex);
            return aIdentifier.compareTo(bIdentifier);
        }

        return compareContent;
    }
}