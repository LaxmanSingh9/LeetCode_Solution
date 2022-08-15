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
    public int uniValueSubtrees(TreeNode root,int prev){
        if(root==null || root.val!=prev){return 0;}
        int left=uniValueSubtrees(root.left,prev);
        int right=uniValueSubtrees(root.right,prev);
        return 1+Math.max(left,right);
    }
    public void solve(TreeNode root,int []ans){
        if(root==null){return;}
        ans[0]=Math.max(ans[0],uniValueSubtrees(root.left,root.val)+uniValueSubtrees(root.right,root.val));
        solve(root.left,ans);
        solve(root.right,ans);
    }
    public int longestUnivaluePath(TreeNode root) {
         int ans[]=new int[1];
         solve(root,ans);
         return ans[0];
    }
}