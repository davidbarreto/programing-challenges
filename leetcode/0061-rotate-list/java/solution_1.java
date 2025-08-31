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
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null) {
            return null;
        }

        ListNode node = head;
        ListNode tail = null;
        int size = 0;
        while (node != null) {
            size++;
            if (node.next == null) {
                tail = node;
            }
            node = node.next;
        }

        //System.out.println("Head = " + head.val + ", Tail = " + tail.val);
        //System.out.println("List size = " + size);
        tail.next = head;

        int rotate = k % size;
        int it = size - rotate;
        ListNode newHead = head;
        ListNode newTail = null;
        //System.out.println("Starting in node number " + it);
        for (int i=0; i < it; i++) {

            //System.out.println("Processing node " + newHead.val);
            if (i == it - 1) {
                //System.out.println("Found new tail at " + newHead.val);
                newTail = newHead;
            }
            newHead = newHead.next;
        }

        //System.out.println("New Head = " + newHead.val + ", New Tail = " + newTail.val);

        newTail.next = null;
        return newHead;
    }
}