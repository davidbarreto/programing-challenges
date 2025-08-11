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

    private Map<Integer, Integer> mapInorder;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Preorder: root, left subtree, right subtree
        // Inorder: left subtree, root, right subtree

        mapInorder = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapInorder.put(inorder[i], i);
        }

        return search(preorder, 0, preorder.length - 1);
    }

    private TreeNode search(int[] preorder, int start, int end) {

        //System.out.println("start = " + start + ", end = " + end);
        
        if (start > end) {
            return null;
        }

        int root = preorder[preorderIndex++];
        TreeNode node = new TreeNode(root);
        int rootIndex = mapInorder.get(root);
        
        node.left = search(preorder, start, rootIndex - 1);
        node.right = search(preorder, rootIndex + 1, end);

        return node;
    }
}