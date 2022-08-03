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
   public int maxDepth(TreeNode root) {
        if(root==null){return 0;}
        int level=0;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            int width=q.size();
            while(width-- > 0) {
            TreeNode node = q.poll();
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null) {
                q.offer(node.right);
            }
        }
            level+=1; //new level added
        }
        return level;     
   }
}

















