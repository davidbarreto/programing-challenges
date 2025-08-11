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
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut head = head; // shadow with mutable binding
        let mut len = 0;
        let mut node = head.as_ref();

        // First pass: calculate the length
        while let Some(current) = node {
            len += 1;
            node = current.next.as_ref();
        }

        // Special case: remove the head
        if n == len {
            return head.unwrap().next;
        }

        // Second pass: find the (len - n - 1)th node (node before the one to remove)
        let mut current = head.as_mut();
        for _ in 0..(len - n - 1) {
            current = current.unwrap().next.as_mut();
        }

        // Remove the next node
        let next = current.as_mut().unwrap().next.take();
        current.as_mut().unwrap().next = next.unwrap().next;

        head
    }
}