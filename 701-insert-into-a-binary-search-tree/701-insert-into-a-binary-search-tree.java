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
    //TC=O(N)
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        TreeNode parent=null;
        TreeNode curr=root;
        while(curr!=null){
            parent=curr;
            if(curr.val>val)
              curr=curr.left;
            else
              curr=curr.right;
        }
        if(parent.val>val){
            parent.left=  new TreeNode(val);
        }
        else{
            parent.right= new TreeNode(val);
        }
        return root;
    }
}