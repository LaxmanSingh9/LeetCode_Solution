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
    public int solve(TreeNode root,String s){
        if(root==null){
            return Integer.parseInt(s,2); 
        }
       
        if(root.left==null || root.right==null){
            return Math.max(solve(root.left,s+root.val),
                 solve(root.right,s+root.val));
        }
        else{
             return solve(root.left,s+root.val)
                    +solve(root.right,s+root.val);
        }
        
    }
    public int sumRootToLeaf(TreeNode root) {
          return solve(root,"");
    }
}