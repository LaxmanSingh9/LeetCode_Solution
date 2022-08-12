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
        }
        return odd>1?false:true;
    }
    int ans=0;
    public void  solve(TreeNode root, int []freq){
        if(root==null)return;
        freq[root.val]=freq[root.val]+1;
        if(root.left==null && root.right==null){
            if(isPseudoPalin(freq))ans+=1;
        }
        solve(root.left,freq);
        solve(root.right,freq);
        freq[root.val]=freq[root.val]-1 ;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int ar[]=new int [10];
        solve(root,ar);
        return ans;
    }
}