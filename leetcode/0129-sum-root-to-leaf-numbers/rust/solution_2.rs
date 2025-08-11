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
    pub fn sum_numbers(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        Solution::dfs(&root, 0)
    }

    fn dfs(root: &Option<Rc<RefCell<TreeNode>>>, current: i32) -> i32 {
        
        if let Some(node) = root.as_ref() {

            let node_borrow = node.borrow();
            let current = current * 10 + node_borrow.val;

            if node_borrow.left.is_none() && node_borrow.right.is_none() {
                return current;
            }

            return Solution::dfs(&node_borrow.left, current) + Solution::dfs(&node_borrow.right, current);
        }

        0
    }
}