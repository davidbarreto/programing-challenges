class Solution {
    public int maxLength(List<String> arr) {
        Set<Character> chars = new HashSet<>();
        return findMaxLength(arr, chars, 0);
    }

    public int findMaxLength(List<String> arr, Set<Character> chars, int position) {
        if (position == arr.size()) {
            return chars.size();
        }

        int res = 0;
        String s = arr.get(position);
        if (!overlap(chars, s)) {
            add(chars, s);
            res = findMaxLength(arr, chars, position+1);
            remove(chars, s);
        }
        int rec = findMaxLength(arr, chars, position+1);
        return Math.max(res, rec);
    }

    private boolean overlap(Set<Character> chars, String s) {
        Set<Character> localChars = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.contains(c) || localChars.contains(c)) {
                return true;
            }
            localChars.add(c);
        }
        return false;
    }

    private void add(Set<Character> chars, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.add(c);
        }
    }

    private void remove(Set<Character> chars, String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.remove(c);
        }
    }
}