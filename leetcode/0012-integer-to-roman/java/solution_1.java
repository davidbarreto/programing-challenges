class Solution {

    private static final List<String> SYMBOLS = fillSymbols();
    private static final List<Integer> NUMBERS = fillNumbers();

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUMBERS.size(); i++) {
            while (num >= NUMBERS.get(i)) {
                sb.append(SYMBOLS.get(i));
                num = num - NUMBERS.get(i);
            }
        }

        return sb.toString();
    }
    
    private static List<String> fillSymbols() {
        return List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
    }

    private static List<Integer> fillNumbers() {
        return List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
    }
}