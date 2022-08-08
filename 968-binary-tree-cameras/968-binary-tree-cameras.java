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
    int ans=0;
    public int solve(TreeNode root){
        if(root==null){
            return 2;
        }
        int left=solve(root.left);
        int right=solve(root.right);
        if(left==0 || right==0){
            ans+=1;
            return 1;
        }
        return left==1 || right==1?2:0;
        
    }
    public int minCameraCover(TreeNode root) {
        int ans1=solve(root);
        return ans1==0?ans+1:ans;
    }
}