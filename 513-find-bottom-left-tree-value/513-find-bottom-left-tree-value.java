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
    public int solve(TreeNode root){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int leftmost=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
          int si=queue.size();leftmost=Integer.MAX_VALUE;
          while(si-->0){
             TreeNode node=queue.poll();
             if(node.left!=null)
                queue.add(node.left);
             if(node.right!=null)
                queue.add(node.right);
             if(leftmost==Integer.MAX_VALUE)
                leftmost=node.val;
           }  
        }
        return leftmost;
    }
    public int findBottomLeftValue(TreeNode root) {
        return solve(root);
    }
}