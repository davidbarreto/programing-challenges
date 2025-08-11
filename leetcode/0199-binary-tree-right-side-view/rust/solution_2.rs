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

        let mut ans: Vec<i32> = Vec::new();
        let mut queue: VecDeque<Rc<RefCell<TreeNode>>> = VecDeque::new();

        if let Some(ref node) = root {

            queue.push_back(node.clone());

            while !queue.is_empty() {
                
                ans.push(queue.back().unwrap().borrow().val);
                let len = queue.len();

                for _ in 0..len {
                    let current = queue.pop_front().unwrap().clone();

                    let left_option = current.borrow().left.clone();
                    let right_option = current.borrow().right.clone();

                    if let Some(ref left) = left_option {
                        queue.push_back(left.clone());
                    }
                    if let Some(ref right) = right_option {
                        queue.push_back(right.clone());
                    }
                }
            }
        }
        ans
    }
}

//1
//2, 3
//5,4