class Solution {
    public String reverseWords(String s) {
        String[] splitted = s.split("\\s+");

        StringBuilder sb = new StringBuilder();
        for (int i = splitted.length -1; i >= 0; i--) {
            if (!splitted[i].isEmpty()) {
                sb.append(splitted[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}