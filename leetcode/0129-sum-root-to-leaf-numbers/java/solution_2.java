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
        return sumNumbers(root, new ArrayList());
    }

    private int sumNumbers(TreeNode root, List<Character> number) {
        if (isLeaf(root)) {
            int ans = convert(number, root.val);
            //System.out.println("Final number: " + ans);
            return ans;
        }

        number.add(toChar(root.val));
        //System.out.println("Current number: " + number);

        int fromLeft = 0;
        if (root.left != null) {
            fromLeft = sumNumbers(root.left, new ArrayList(number));
        }

        int fromRight = 0;
        if (root.right != null) {
            fromRight = sumNumbers(root.right, new ArrayList(number));
        }

        //System.out.println("Suming: " + fromLeft + " + " + fromRight + " = " + (fromLeft + fromRight));
        return fromLeft + fromRight;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private Integer convert(List<Character> chars, int lastVal) {
        chars.add(toChar(lastVal));
        return Integer.parseInt(toString(chars));
    }

    private Character toChar(int digit) {
        return Character.forDigit(digit, 10);
    }

    private String toString(List<Character> chars) {
        return chars.stream().map(String::valueOf).collect(Collectors.joining());
    }
}