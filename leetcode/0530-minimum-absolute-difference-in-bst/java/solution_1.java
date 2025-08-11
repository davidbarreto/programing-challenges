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
    public int getMinimumDifference(TreeNode root) {
        
        List<Integer> sortedNums = new ArrayList<>();
        inOrder(root, sortedNums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < sortedNums.size(); i++) {
            int diff = Math.abs(sortedNums.get(i) - sortedNums.get(i-1));
            if (diff < min) {
                min = diff;
            }
        }
        
        return min;
    }
    
    private void inOrder(TreeNode root, List<Integer> nodes) {
        
        if (root == null) {
            return;
        }
        
        inOrder(root.left, nodes);
        nodes.add(root.val);
        inOrder(root.right, nodes);
    }
}