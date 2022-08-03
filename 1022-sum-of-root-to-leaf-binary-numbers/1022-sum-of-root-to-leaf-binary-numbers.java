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
    public int solve(TreeNode root,String s){
        if(root==null){
           int val=0;
           for(int i=0;i<s.length();i+=1){
               val+=(s.charAt(i)-'0')*(int)Math.pow(2,i);
           }
           return val; 
        }
       
        if(root.left==null || root.right==null){
            return Math.max(solve(root.left,root.val+s),
                 solve(root.right,root.val+s));
        }
        else{
             return solve(root.left,root.val+s)
                    +solve(root.right,root.val+s);
        }
        
    }
    public int sumRootToLeaf(TreeNode root) {
          return solve(root,"");
    }
}