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
    //TC=O(h)
    public TreeNode insertIntoBST(TreeNode root, int val) {
          if(root==null){return new TreeNode(val);}//return new node
          if(root.val>val){root.left=insertIntoBST(root.left,val);}//go to left
          if(root.val<val){root.right=insertIntoBST(root.right,val);}//go to right
          return root;//return root
    }
}