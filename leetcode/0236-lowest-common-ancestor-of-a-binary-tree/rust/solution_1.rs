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
impl Solution {
    pub fn lowest_common_ancestor(root: Option<Rc<RefCell<TreeNode>>>, p: Option<Rc<RefCell<TreeNode>>>, q: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        
        if let Some(node) = &root {
            let node_borrow = node.borrow();

            if Rc::ptr_eq(node, p.as_ref().unwrap()) || Rc::ptr_eq(node, q.as_ref().unwrap()) {
                return root.clone();
            }

            let from_left = Solution::lowest_common_ancestor(node_borrow.left.clone(), p.clone(), q.clone());
            let from_right = Solution::lowest_common_ancestor(node_borrow.right.clone(), p.clone(), q.clone());

            if from_left.is_some() && from_right.is_some() {
                return root.clone();
            }

            if from_left.is_some() {
                return from_left;
            }

            if from_right.is_some() {
                return from_right;
            }
        }
        None
    }
}