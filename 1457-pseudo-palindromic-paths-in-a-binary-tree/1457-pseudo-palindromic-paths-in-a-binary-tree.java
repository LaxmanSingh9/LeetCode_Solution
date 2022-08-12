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
    public boolean isPseudoPalin(int []ar){
        int even=0,odd=0;
        for(int i=0;i<10;i+=1){
           if(ar[i]>0){
               if(ar[i]%2==0)even+=1;
               else odd+=1;
           }
           if(odd>1)return false;
        }
        return true;
    }
   public int  solve(TreeNode root, int []freq){
        if(root==null)return 0;
        freq[root.val]=freq[root.val]+1;
        if(root.left==null && root.right==null){
           int a=isPseudoPalin(freq)?1:0;
           freq[root.val]-=1;
           return a;
        }
        int l=solve(root.left,freq);
        int r=solve(root.right,freq);
        freq[root.val]=freq[root.val]-1 ;
        return l+r;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        return  solve(root,new int [10]);
    }
}