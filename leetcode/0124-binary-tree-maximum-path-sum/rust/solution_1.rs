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

struct Answer {
    max_path: i32
}

use std::rc::Rc;
use std::cell::RefCell;

impl Solution {
    pub fn max_path_sum(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        
        let mut max_result = Answer { max_path: i32::MIN };
        Self::search(&root, &mut max_result);
        max_result.max_path

    }

    fn search(root: &Option<Rc<RefCell<TreeNode>>>, max_result: &mut Answer) -> i32{

        if let Some(node) = &root {

            let node_borrowed = node.borrow();
            let node_value = node_borrowed.val;
            let left = Self::search(&node_borrowed.left, max_result).max(0);
            let right = Self::search(&node_borrowed.right, max_result).max(0);

            let path_sum = node_value + left + right;
            max_result.max_path = max_result.max_path.max(path_sum);
            return node_value + left.max(right);
        }
        0
    }
}