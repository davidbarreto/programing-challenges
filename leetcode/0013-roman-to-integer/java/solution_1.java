class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = fillMap();
        int i = s.length() - 1;
        int ans = 0;
        while (i >= 0) {
            char c = s.charAt(i);
            int val = map.get(c);
            if (i > 0 && map.get(s.charAt(i-1)) < val) {
                val -= map.get(s.charAt(i-1));
                i--;
            }
            ans += val;
            i--;
        }
        
        return ans;
    }
    
    private Map<Character, Integer> fillMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        return map;
    }
}