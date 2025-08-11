class Solution {
    public int strStr(String haystack, String needle) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int firstOccurrence = -1;
        while (i < haystack.length()) {
            
            //System.out.printf("i=%d,j=%d\n", i, j);
            if (j >= needle.length()) {
                break;
            }
            
            //System.out.printf("Comapring hay[%d]=%c,need[%d]=%c\n", i, haystack.charAt(i), j, needle.charAt(j));
            if (j > 0 && haystack.charAt(i) == needle.charAt(0)) {
                    stack.add(i);    
            }
            
            if (haystack.charAt(i) == needle.charAt(j)) {
                
                if (firstOccurrence == -1) {
                    firstOccurrence = i;
                }
                j++;
                i++;
            } else {
                firstOccurrence = -1;
                j = 0;
                i = stack.isEmpty() ? (i+1) : stack.remove();
            }
            
            //System.out.printf("end loop with i=%d,j=%d,firstOc=%d,stack=%s\n", i, j, firstOccurrence, stack.toString());
            //System.out.println("-------------");
        }
        
        return j < needle.length() ? -1 : firstOccurrence;
    }
}