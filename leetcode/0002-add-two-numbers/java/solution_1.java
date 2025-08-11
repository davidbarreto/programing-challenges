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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode watcher = new ListNode(-1);
        ListNode prev = watcher;
        ListNode tail = null;
        int rest = 0;
        while(l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;

            int sum = v1 + v2 + rest;
            int digit = sum % 10;
            rest = sum / 10;

            tail = new ListNode(digit);
            prev.next = tail;
            prev = tail;
            
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (rest > 0) {
            prev.next = new ListNode(rest);
        }
        
        return watcher.next;
    }
}