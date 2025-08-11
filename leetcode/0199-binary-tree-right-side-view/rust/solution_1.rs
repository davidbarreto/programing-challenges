// Definition for a binary tree node.
// #[derive(Debug, PartialEq, Eq)]
// pub struct TreeNode {
//   pub val: i32,
//   pub left: Option<Rc<RefCell<TreeNode>>>,
//   pub right: Option<Rc<RefCell<TreeNode>>>,
// }
// 
// impl TreeNode {
//   #[inline]
//   pub fn new(val: i32) -> Self {
//     TreeNode {
//       val,
//       left: None,
//       right: None
//     }
//   }
// }

// 1
// 2, 3
// 4
// 5
use std::rc::Rc;
use std::cell::RefCell;
use std::collections::VecDeque;

impl Solution {
    pub fn right_side_view(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut right_view = Vec::new();
        let mut queue = VecDeque::new();

        if let Some(node) = root {
            queue.push_back(node);

            while !queue.is_empty() {
                let level_size = queue.len();
                right_view.push(queue.back().unwrap().borrow().val);

                for _ in 0..level_size {
                    let current = queue.pop_front().unwrap();
                    let current_ref = current.borrow();

                    if let Some(left) = &current_ref.left {
                        queue.push_back(left.clone());
                    }
                    if let Some(right) = &current_ref.right {
                        queue.push_back(right.clone());
                    }
                }
            }
        }

        right_view
    }
}