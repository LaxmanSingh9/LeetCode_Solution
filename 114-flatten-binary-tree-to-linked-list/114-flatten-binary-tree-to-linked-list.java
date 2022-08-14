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
   public  TreeNode solve(TreeNode root,TreeNode  prev){
        if(root==null){return prev;}
        TreeNode r=solve(root.right,prev);
        TreeNode l=solve(root.left,r);
        root.right=l;
        root.left=null;
        return root;
        
    }
    public void flatten(TreeNode root) {
        solve(root,null);
    }
}