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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) {
            return null;
        }

        // Remove duplicates
        ListNode guard = new ListNode(Integer.MIN_VALUE, head);

        ListNode lastValid = guard;
        ListNode node = head;
        int lastDeleted = guard.val;
        while (node != null) {

            if (node.next != null && node.next.val != node.val && node.val != lastDeleted) {
                //System.out.println("Now " + toString(lastValid) + ".next = " + toString(node));
                lastValid.next = node;
                //System.out.println("Now lastValid is " + toString(node));
                lastValid = node;
            } else {
                if (node.next != null) {
                    //System.out.println("Last deleted is " + node.val);
                    lastDeleted = node.val;
                } else if (node.val != lastDeleted) {
                    lastValid.next = node;
                } else {
                    lastValid.next = null;
                }
            }

            node = node.next;
        }

        return guard.next;
    }

    private String toString(ListNode node) {
        return node != null ? String.valueOf(node.val) : "null";
    }
}