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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int reverseLen = right - left;

        int i = 1;
        ListNode before = null;
        ListNode after = null;
        ListNode node = head;

        Deque<ListNode> stack = new ArrayDeque<>();

        while (node != null && reverseLen >= 0) {

            // Save the node before the reversed part (after will the last head after loop)
            if (i < left) {
                before = node;
            }

            // Process the reversed part
            if (i >= left && i <= right) {
                stack.addFirst(node);
                reverseLen--;
            }

            i++;
            node = node.next;
        }

        after = node;

        ListNode firstReversed = stack.peekFirst();
        node = before;
        while (!stack.isEmpty()) {
            ListNode n = stack.removeFirst();
            if (node != null) {
                node.next = n;
            }
            node = n;
        }

        if (before == null) {
            head = firstReversed;
        }

        node.next = after;
        return head;
    }
}