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
    pub fn rotate_right(head: Option<Box<ListNode>>, k: i32) -> Option<Box<ListNode>> {
        // Step 1: collect all nodes into a vector, taking ownership
        let mut nodes = vec![];
        let mut curr = head;
        while let Some(mut node) = curr {
            curr = node.next.take();
            nodes.push(node);
        }

        let n = nodes.len();
        if n == 0 {
            return None;
        }

        let k = (k as usize) % n;
        if k == 0 {
            // Rebuild original list
            let mut new_head = nodes.remove(0);
            let mut tail = &mut new_head;
            for node in nodes.into_iter() {
                tail.next = Some(node);
                tail = tail.next.as_mut().unwrap();
            }
            tail.next = None;
            return Some(new_head);
        }

        // Step 2: split vector into two parts and rotate
        let split = n - k;
        let mut new_head = nodes.remove(split);
        let mut tail = &mut new_head;

        // Attach the rest of the nodes after split
        for node in nodes.split_off(split).into_iter() {
            tail.next = Some(node);
            tail = tail.next.as_mut().unwrap();
        }

        // Attach nodes before split
        for node in nodes.into_iter() {
            tail.next = Some(node);
            tail = tail.next.as_mut().unwrap();
        }

        tail.next = None;
        Some(new_head)
    }
}
