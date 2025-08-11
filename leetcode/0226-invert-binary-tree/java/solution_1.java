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
    public TreeNode invertTree(TreeNode root) {
        
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            
            TreeNode current = queue.poll();
            switchChildren(current);
            List<TreeNode> children = neighbors(current);
            for (TreeNode node : children) {
                queue.add(node);
            }
        }
        
        return root;
    }
    
    private List<TreeNode> neighbors(TreeNode node) {
        List<TreeNode> list = new ArrayList<>();
        if (node.left != null) {
            list.add(node.left);
        }
        
        if (node.right != null) {
            list.add(node.right);
        }
        return list;
    }
    
    private void switchChildren(TreeNode node) {
        TreeNode temp = node.right;
        node.right = node.left;
        node.left = temp;
    }
}