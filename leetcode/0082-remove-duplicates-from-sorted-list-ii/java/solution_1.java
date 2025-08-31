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

        Set<Integer> uniqueValues = new HashSet<>();
        Set<Integer> duplicateValues = new HashSet<>();

        // Find duplicates
        ListNode node = head;
        while (node != null) {

            if (uniqueValues.contains(node.val)) {
                duplicateValues.add(node.val);
            }
            uniqueValues.add(node.val);
            node = node.next;
        }

        // Remove duplicates
        ListNode guard = new ListNode();
        guard.next = head;

        ListNode previous = guard;
        node = head;
        while (node != null) {

            while (node != null && duplicateValues.contains(node.val)) {
                node = node.next;
            }

            previous.next = node;
            previous = node;

            if (node != null) {
                node = node.next;
            }
        }
        return guard.next;
    }
}