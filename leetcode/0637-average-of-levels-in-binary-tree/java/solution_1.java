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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> sum = new ArrayList<>();
        List<Double> qtd = new ArrayList<>();
        
        Deque<QueueItem> queue = new ArrayDeque<>();
        queue.add(new QueueItem(root, 0));
        
        while(!queue.isEmpty()) {
            QueueItem item = queue.poll();
            
            //System.out.println(item);
            //System.out.println(queue);
            //System.out.println(sum);
            //System.out.println(qtd);
            //System.out.println("--------");
            
            if (sum.size() <= item.level()) {
                sum.add(0.0);
                qtd.add(0.0);
            }
            
            sum.set(item.level(), sum.get(item.level()) + item.node().val);
            qtd.set(item.level(), qtd.get(item.level()) + 1);
            
            if (item.node().left != null) {
                queue.add(new QueueItem(item.node().left, item.level()+1));   
            }
            
            if (item.node().right != null) {
                queue.add(new QueueItem(item.node().right, item.level()+1));
            }
            
        }
        
        List<Double> ans = new ArrayList<>();
        for (int i = 0; i < sum.size(); i++) {
            ans.add(sum.get(i)/qtd.get(i));
        }
        return ans;
    }
    
    record QueueItem(TreeNode node, Integer level) {}
}