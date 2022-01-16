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
    TreeNode cur;
    public void inorder(TreeNode root) {
        if(root==null){
            return ;
        }
        inorder(root.left);
        root.left=null;
        cur.right=root;
        cur=root;
        inorder(root.right);
        
        
    }
    public TreeNode increasingBST(TreeNode root){
       TreeNode answer =new TreeNode(0);
       cur=answer;
       inorder(root);
       return answer.right; 
    }
}