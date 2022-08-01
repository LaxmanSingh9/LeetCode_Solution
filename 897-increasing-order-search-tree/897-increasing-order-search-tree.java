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
    TreeNode currNode;
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        root.left=null;
        currNode.right=root;
        currNode=root;
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
       TreeNode answer=new TreeNode(0);
       currNode=answer;
       inorder(root);
       return answer.right; 
    } 
}