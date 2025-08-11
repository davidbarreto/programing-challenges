/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if (head == null || head.next == null) {
            return true;
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            //System.out.printf("slow=%d, fast=%d\n", slow.val, fast.val);
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
            //System.out.printf("stack=%s\n", stack.toString());
        }
        
        if (slow != null && slow.next != null && !stack.isEmpty() && slow.next.val == stack.peek()) {
            slow = slow.next;    
        }
        
        //System.out.printf("Starting half with slow=%d, stack=%s\n", slow.val, stack.toString());
        while (slow != null) {
            //System.out.printf("slow=%d, stack=%s\n", slow.val, stack.toString());
            if (stack.isEmpty() || stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        
        return stack.isEmpty();
    }
}