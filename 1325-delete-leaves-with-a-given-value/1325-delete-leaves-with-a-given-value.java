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
    boolean  isPresent=true;
    public TreeNode solve(TreeNode  root ,int target){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null && root.val==target){
            isPresent=true;
            return null;
        }
        root.left=solve(root.left,target);
        root.right=solve(root.right,target);
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        while(isPresent==true && root!=null){
            isPresent=false;
            root=solve(root,target);
        }
        return root;
    }
}