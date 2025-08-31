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
    pub fn delete_duplicates(head: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut dummy = Box::new(ListNode { val: 0, next: head });
        let mut prev = &mut dummy;

        while let Some(mut node) = prev.next.take() {
            let mut dup = false;

            // Walk to the end of the run of equal values
            while let Some(ref nxt) = node.next {
                if nxt.val == node.val {
                    let next_node = node.next.take().unwrap();
                    node = next_node;
                    dup = true;
                } else {
                    break;
                }
            }

            if dup {
                // Skip the whole run
                prev.next = node.next.take();
            } else {
                // Keep single node and advance
                prev.next = Some(node);
                prev = prev.next.as_mut().unwrap();
            }
        }

        dummy.next
    }
}