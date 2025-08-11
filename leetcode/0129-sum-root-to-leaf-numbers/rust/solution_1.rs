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
        
        let Some(node) = root else { return 0 };
        
        let node = node.borrow();
        let current = current * 10 + node.val;

        if node.left.is_none() && node.right.is_none() {
            return current;
        }

        return Solution::dfs(&node.left, current) + Solution::dfs(&node.right, current);
    }
}