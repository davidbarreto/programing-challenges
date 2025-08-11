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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, "");
    }

    private int sumNumbers(TreeNode root, String number) {
        if (isLeaf(root)) {
            //System.out.println("Final number: " + number + String.valueOf(root.val));
            return Integer.parseInt(number + String.valueOf(root.val));
        }
        
        String current = number + String.valueOf(root.val);
        //System.out.println("Current number: " + current);

        int fromLeft = 0;
        if (root.left != null) {
            fromLeft = sumNumbers(root.left, current);
        }

        int fromRight = 0;
        if (root.right != null) {
            fromRight = sumNumbers(root.right, current);
        }

        //System.out.println("Suming: " + fromLeft + " + " + fromRight + " = " + (fromLeft + fromRight));
        return fromLeft + fromRight;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}