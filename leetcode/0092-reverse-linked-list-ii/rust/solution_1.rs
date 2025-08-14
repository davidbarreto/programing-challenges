// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn reverse_between(
        head: Option<Box<ListNode>>,
        left: i32,
        right: i32,
    ) -> Option<Box<ListNode>> {
        if left == right {
            return head;
        }

        let mut dummy = Box::new(ListNode { val: 0, next: head });
        let mut prev = &mut dummy;

        // Step 1: move prev to node before `left`
        for _ in 0..(left - 1) {
            if prev.next.is_none() {
                return dummy.next; // list too short
            }
            prev = prev.next.as_mut().unwrap();
        }

        // Step 2: reverse the sublist
        let mut curr = prev.next.take();
        let mut prev_sublist: Option<Box<ListNode>> = None;

        for _ in left..=right {
            if curr.is_none() {
                break; // reached end of list early
            }
            let mut next = curr.as_mut().unwrap().next.take();
            curr.as_mut().unwrap().next = prev_sublist;
            prev_sublist = curr;
            curr = next;
        }

        // prev.next was None, so prev points to before the reversed part
        // Now reconnect: find tail of reversed section
        let mut tail = prev_sublist.as_mut().unwrap();
        while tail.next.is_some() {
            tail = tail.next.as_mut().unwrap();
        }
        tail.next = curr;

        prev.next = prev_sublist;

        dummy.next
    }
}
