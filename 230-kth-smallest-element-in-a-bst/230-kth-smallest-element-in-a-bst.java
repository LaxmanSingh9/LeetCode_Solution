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
    int index=0;
    public int solve(TreeNode root,int k){
        if(root.left!=null){
             int left=solve(root.left,k);
             if(left!=0)return left;
        }
        index+=1;
        if(index==k){
            return root.val;
        }
        if(root.right!=null){
           int right=solve(root.right,k);
           if(right!=0)return right;
        }
        return 0;
    }
    public int kthSmallest(TreeNode root, int k) {
        return solve(root,k);
    }
}