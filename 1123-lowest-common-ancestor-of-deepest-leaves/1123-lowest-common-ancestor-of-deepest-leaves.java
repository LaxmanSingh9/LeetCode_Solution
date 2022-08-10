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
    public int findDepthOfTree(TreeNode node,int d){
        if(node==null){return d-1;}
        int l=findDepthOfTree(node.left,d+1);
        int r=findDepthOfTree(node.right,d+1);
        return Math.max(l,r);
    }
    public TreeNode solve(TreeNode node,int d,int maxDepth){
        if(node==null){return null;}
        if(d==maxDepth){return node;}
        TreeNode left=solve(node.left,d+1,maxDepth);
        TreeNode right=solve(node.right,d+1,maxDepth);
        if(left!=null && right!=null){
            return node;
        }
        return left==null?right:left;
        
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root,0,findDepthOfTree(root,0));
    }
}