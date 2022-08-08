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
    private int ans1=0;
    public int solve(TreeNode root,int max,int ans){
      if(root==null){return ans;} 
      if(max<=root.val){ans+=1;ans1+=1;}
      max=Math.max(max,root.val);
      int left=solve(root.left,max,ans);
      int right=solve(root.right,max,ans);
      return left+right;
    }
    public int goodNodes(TreeNode root) {
        solve(root,Integer.MIN_VALUE,0);
        return ans1;
    } 
}