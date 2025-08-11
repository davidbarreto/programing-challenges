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
use std::rc::Rc;
use std::cell::RefCell;
use std::collections::VecDeque;

impl Solution {
    pub fn level_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        
        if root.is_none() {
            return Vec::new();
        }

        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut queue = VecDeque::new();
        queue.push_back(root.unwrap());

        while !queue.is_empty() {
            let level = queue.len();

            let mut internal = Vec::new();
            for i in 0..level {
                let current = queue.pop_front().unwrap();
                let current_ref = current.borrow();
                internal.push(current_ref.val);

                if let Some(left) = &current_ref.left {
                    queue.push_back(left.clone());
                }

                if let Some(right) = &current_ref.right {
                    queue.push_back(right.clone());
                }
            }

            result.push(internal);
        }

        return result;
    }
}