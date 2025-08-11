class Solution {

    static final long powerOfTen[] = {1L,10L,100L,1000L,10000L,100000L,1000000L,10000000L,100000000L,1000000000L};

    public int myAtoi(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int start = 0;
        // Ignore trailing spaces
        while(start < s.length() && s.charAt(start) == ' ') {
            start++;
        }

        // Handle signal
        int signal = 1;
        char firstNonSpaceChar = start < s.length() ? s.charAt(start) : '?';
        if (firstNonSpaceChar == '+' || firstNonSpaceChar == '-') {
            if (firstNonSpaceChar == '-') {
                signal = -1;
            }
            start++;
        }

        // Ignore trailing zeros
        while(start < s.length() && s.charAt(start) == '0') {
            start++;
        }

        List<Character> numberChar = new ArrayList<>();
        for (int i = start; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            numberChar.add(ch);
        }

        int len = numberChar.size();
        if (len > 10 || (len == 10 && (numberChar.get(0) - '0') > 2)) {
            return boundary(signal);
        }

        long result = 0;
        boolean exceeds32bits = false;
        for (int i = len - 1; i >= 0; i--) {
            int exp = len -i-1;
            char ch = numberChar.get(i);

            long element = (ch - '0') * powerOfTen[exp];
            if (element > Integer.MAX_VALUE) {
                exceeds32bits = true;
                break;
            }
            result += element;
            if (result > Integer.MAX_VALUE) {
                exceeds32bits = true;
                break;
            }
        }

        if (exceeds32bits) {
            return boundary(signal);
        }

        return signal * (int) result;
    }

    private int boundary(int signal) {
        if (signal > 0) {
            return Integer.MAX_VALUE;
        } else {
            return Integer.MIN_VALUE;
        }
    }
}