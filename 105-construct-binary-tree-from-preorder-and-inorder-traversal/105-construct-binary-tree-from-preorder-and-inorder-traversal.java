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
    int i=0;
    Map<Integer,Integer>map=new HashMap<>();
    public TreeNode solve(int[]pre,int[]in,int s,int e){
        if(s>e){return null;}
        TreeNode root=new TreeNode(pre[i]);
        int divPoint=map.get(pre[i]);i+=1;
        root.left=solve(pre,in,s,divPoint-1);
        root.right=solve(pre,in,divPoint+1,e);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       for(int j=0;j<inorder.length;j+=1)
           map.put(inorder[j],j);
       return solve(preorder,inorder,0,inorder.length-1);
    }
}