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
    TreeNode prev=new TreeNode(Integer.MIN_VALUE);
    TreeNode firstEle=null;TreeNode secondEle=null;     
    public void inorderBST(TreeNode root){
        if(root==null){return ;}
        inorderBST(root.left);
        
        if(firstEle==null && prev.val>root.val){ //node will be previous node
            firstEle=prev;
        }
        if(firstEle!=null && prev.val>root.val){//node  will be root
            secondEle=root;
        }             
        prev=root;
        inorderBST(root.right);                    
    }
    public void recoverTree(TreeNode root) {
        System.out.println(Integer.MIN_VALUE);
        inorderBST(root);
        int buffer=firstEle.val;
        firstEle.val=secondEle.val;
        secondEle.val=buffer;
        
        
    }
}