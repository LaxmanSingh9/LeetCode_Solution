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
    int prev=0;
    //Reverse Inorder Traversal
    //TC=O(n),since accessing every node once
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        convertBST(root.right);
        prev+=root.val;
        root.val=prev;
        convertBST(root.left);
        return root;
        
    }
}