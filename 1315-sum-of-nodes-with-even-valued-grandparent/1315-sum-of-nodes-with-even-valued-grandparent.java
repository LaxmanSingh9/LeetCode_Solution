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
    int ans=0;
    public void solve(TreeNode root,int prev){
        if(root==null){return;}
        if(root.left!=null){
          ans+=prev%2==0?root.left.val:0;
          solve(root.left,root.val);
        }
        if(root.right!=null){
          ans+=prev%2==0?root.right.val:0;
          solve(root.right,root.val);
        }
          
        
    }
    public int sumEvenGrandparent(TreeNode root) {
        solve(root,-1);
        return ans;
    }
}