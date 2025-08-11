/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        search(root);
        return ans;
    }

    private int search(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(search(root.left), 0);
        int right = Math.max(search(root.right), 0);

        int pathSum = root.val + left + right;
        ans = Math.max(ans, pathSum);

        return root.val + Math.max(left, right);
    }
}