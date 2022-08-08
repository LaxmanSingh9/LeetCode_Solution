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
    public void solve(TreeNode root,int max){
      if(root==null){return ;} 
      if(max<=root.val){ans1+=1;}
      max=Math.max(max,root.val);
      solve(root.left,max);
      solve(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        solve(root,Integer.MIN_VALUE);
        return ans1;
    } 
}