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
    int ans=0;
    public void solve(TreeNode root){
        if(root==null){return;}
        ans=Math.max(ans,uniValueSubtrees(root.left,root.val)+uniValueSubtrees(root.right,root.val));
        solve(root.left);
        solve(root.right);
    }
    public int longestUnivaluePath(TreeNode root) {
         solve(root);
         return ans;
    }
}