class Solution {

    private static final Map<Integer, String> MAP = fillMap();
    private static final List<Integer> NUMS = fillList();

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        int n = num;
        int level = 1;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            int number = digit * level;
            
            sb.insert(0, toRoman(digit, level, number));
            
            level *= 10;
        }
        
        return sb.toString();
    }

    private String toRoman(int digit, int level, int num) {

        if (num == 0) {
            return "";
        }

        if (digit != 4 && digit != 9) {
            int index = Collections.binarySearch(NUMS, num);
            if (index < 0) {
                index = -(index + 1) - 1;
            }
            int key = NUMS.get(index);
            int val = num - key;

            return MAP.get(key) + toRoman(val / level, level, val);
            
        } else {

            int index = Collections.binarySearch(NUMS, num);
            if (index < 0) {
                index = -(index + 1);
            }

            int key = NUMS.get(index);
            int val = key - num;
            return toRoman(val / level, level, val) + MAP.get(key);
        }
    }
    
    private static Map<Integer, String> fillMap() {
        return Map.of(1, "I", 5, "V", 10, "X", 50, "L", 100, "C", 500, "D", 1000, "M");
    }

    private static List<Integer> fillList() {
        return List.of(1, 5, 10, 50, 100, 500, 1000);
    }
}