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
    int i;
    Map<Integer,Integer>map=new HashMap<>();
    public TreeNode solve(int[]post,int[]in,int s,int e){
        if(s>e){return null;}
        TreeNode root=new TreeNode(post[i--]);
        int pos=map.get(root.val);
        root.right=solve(post,in,pos+1,e);
        root.left=solve(post,in,s,pos-1);
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       for(int j=0;j<inorder.length;j+=1)
           map.put(inorder[j],j);
       i=postorder.length-1;
       return solve(postorder,inorder,0,postorder.length-1);
    }
   
}