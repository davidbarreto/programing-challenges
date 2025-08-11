/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root == p || root == q) {
            return root;
        }

        TreeNode fromLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode fromRight = lowestCommonAncestor(root.right, p, q);

        if (fromLeft != null && fromRight != null) {
            return root;
        }

        if (fromLeft != null) {
            return fromLeft;
        }

        if (fromRight != null) {
            return fromRight;
        }

        return null;
    }
}