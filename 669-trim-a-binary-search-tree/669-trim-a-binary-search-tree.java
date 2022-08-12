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
    public TreeNode solve(TreeNode root,int low ,int high){
        if(root==null)
          return null;
        if(root.val>=low && root.val<=high){
            root.left=solve(root.left,low,high);
            root.right=solve(root.right,low,high); 
        }
        else if(root.val<low){
           root=solve(root.right,low,high);
        }
        else if(root.val>high){
            root=solve(root.left,low,high);
        }
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return solve(root,low,high);
    }
}