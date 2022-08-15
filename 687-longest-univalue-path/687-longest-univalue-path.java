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
   public int solve(TreeNode root,int val,int []ans){
        if(root==null){return 0;}
        int left=solve(root.left,root.val,ans);
        int right=solve(root.right,root.val,ans);
        ans[0]=Math.max(ans[0],left+right);
        if(root.val==val)
            return 1+Math.max(left,right);
        return 0;    
    }
    public int longestUnivaluePath(TreeNode root) {
         if(root==null)return 0; 
         int ans[]=new int[1];
         solve(root,root.val,ans);
         return ans[0];
    }
}