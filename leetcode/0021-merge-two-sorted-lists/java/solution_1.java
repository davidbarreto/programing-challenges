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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null) {
            return list2;
        }
        
        if (list2 == null) {
            return list1;
        }
        
        ListNode head = null;
        ListNode other = null;
        
        if (list1.val < list2.val) {
            head = list1;
            other = list2;
        } else {
            head = list2;
            other = list1;
        }
        
        ListNode list = head;
        while (other != null) {
            while (list.next != null && list.next.val <= other.val) {
                list = list.next;
            }

            ListNode next = other.next;
            other.next = list.next;
            list.next = other;
            other = next;
        }
        
        if (other != null) {
           list.next = other;
        }
        
        return head; 
    }
}