/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
           if(root==null){return null;}
           if(root.val==p.val || root.val==q.val){return root;}     
           if(root.val>p.val && root.val<q.val){return root;}
           if(root.val>q.val && root.val<p.val){return root;}
           TreeNode node1=lowestCommonAncestor(root.left,p,q);
           TreeNode node2=lowestCommonAncestor(root.right,p,q);
           if(node1!=null){
               return node1;
           }
           return node2;
    }
}