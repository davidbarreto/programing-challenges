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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Preorder: root, left subtree, right subtree
        // Inorder: left subtree, root, right subtree

        Map<Integer, Integer> indexPreorder = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            indexPreorder.put(preorder[i], i);
        }

        TreeNode node = search(preorder[0], 0, preorder.length - 1, preorder, inorder, indexPreorder);

        return node;
    }

    private TreeNode search(int root, int start, int end, int[] preorder, int[] inorder, Map<Integer, Integer> indexPreorder) {

        //System.out.println("Root = " + root + ", start = " + start + ", end = " + end);
        
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(root);
        int inorderRootIndex = search(inorder, start, end + 1, root);
        
        node.left = search(calculateRoot(start, inorderRootIndex - 1, inorder, indexPreorder),
            start, inorderRootIndex - 1, preorder, inorder, indexPreorder);
        node.right = search(calculateRoot(inorderRootIndex + 1, end, inorder, indexPreorder),
            inorderRootIndex + 1, end, preorder, inorder, indexPreorder);

        return node;
    }

    private int search(int[] array, int from, int to, int key) {
        for (int i = from; i < to; i++) {
            if (array[i] == key) {
                return i;
            }
        }

        return -1;
    }

    private int calculateRoot(int start, int end, int[] inorder, Map<Integer, Integer> indexPreorder) {

        //System.out.println("Calculating root: start = " + start + ", end = " + end);
        int minIndex = Integer.MAX_VALUE;
        int root = 0;
        for (int i = start; i <= end; i++) {
            int val = inorder[i];
            int index = indexPreorder.get(val);
            if (index < minIndex) {
                //System.out.println("Index: " + index + ": Changing root [" + root + "] to [" + val + "]");
                minIndex = index;
                root = val;
            }
        }

        //System.out.println("Calculated root = " + root);

        return root;
    }
}