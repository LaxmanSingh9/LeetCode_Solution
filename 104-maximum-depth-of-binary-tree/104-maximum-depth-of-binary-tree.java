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
        if(root==null){return 0;}
        int ans=1,currDepth=0;
        Queue<TreeNode>q=new LinkedList<>();
        Queue<Integer>depth=new LinkedList<>();
        q.add(root);depth.add(1);
        while(q.size()>0){
            TreeNode node=q.poll();
            currDepth=depth.poll();
            ans=Math.max(ans,currDepth);
            if(node.left!=null){
               q.add(node.left);depth.add(currDepth+1);
            }
            if(node.right!=null){
               q.add(node.right);depth.add(currDepth+1);
            }
        }
        return ans;
    }

     public int maxDepth(TreeNode root) {
        return solve(root);  
   }
}

















