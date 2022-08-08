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
    public int solve(TreeNode root,int max){
      if(root==null){return 0;} 
      int ans=root.val>=max?1:0;
      ans+=solve(root.left,Math.max(max,root.val));
      ans+=solve(root.right,Math.max(max,root.val));
      return ans;
    }
    public int goodNodes(TreeNode root){
        return solve(root,Integer.MIN_VALUE);
    } 
}