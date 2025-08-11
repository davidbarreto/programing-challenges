class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        Map<Character, Character> map = new HashMap<>();
        Set<Character> mapped = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);
            //System.out.printf("map=%s\n", map.toString());
            //System.out.printf("s[%d]='%c' t[%d]='%c'\n", i, schar, i, tchar);
            if (map.containsKey(schar)) {
                if (map.get(schar) != tchar) {
                    return false;
                }
            } else {
                if (mapped.contains(tchar)) {
                    return false;
                }
                map.put(schar, tchar);
                mapped.add(tchar);
            }
        }
        
        return true;
    }
}