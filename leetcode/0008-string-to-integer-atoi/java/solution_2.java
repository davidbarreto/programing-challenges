class Solution {

    static final long powerOfTen[] = {1L,10L,100L,1000L,10000L,100000L,1000000L,10000000L,100000000L,1000000000L};

    public int myAtoi(String s) {
        
        s = s.trim();

        int signal = 1;
        long result = 0;
        List<Character> numberChar = new ArrayList<>();
        boolean trailingZeros = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-')) {
                if (ch == '-') {
                    signal = -1;
                }
                continue;
            }

            if (trailingZeros && ch == '0') {
                continue;
            }

            if (!Character.isDigit(ch)) {
                break;
            }

            if (ch != '0') {
                trailingZeros = false;
            }
            numberChar.add(ch);
        }

        System.out.println(numberChar);

        int len = numberChar.size();
        if (len > 10 || (len == 10 && (numberChar.get(0) - '0') > 2)) {
            return boundary(signal);
        }

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