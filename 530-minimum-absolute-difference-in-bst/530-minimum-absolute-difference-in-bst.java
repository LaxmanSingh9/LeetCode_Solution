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
    int prev=-1000000;
    int min=Integer.MAX_VALUE;
    //InOrder Traversal Property, 
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return min;
        }
        getMinimumDifference(root.left);
        min=Math.min(min,root.val-prev);
        prev=root.val;
        getMinimumDifference(root.right);
        return min;
        
    }
}









