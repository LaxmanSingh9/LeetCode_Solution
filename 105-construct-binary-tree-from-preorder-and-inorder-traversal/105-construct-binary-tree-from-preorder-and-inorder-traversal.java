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
 
    public TreeNode solve(int[]pre,int[]in,int s,int e,int preS,int preE,Map<Integer,Integer>map){
        if(s>e || preS>preE){return null;}
        TreeNode root=new TreeNode(pre[preS]);
        int inRoot=map.get(root.val);
        int numLeft=inRoot-s;
        root.left=solve(pre,in,s,inRoot-1,preS+1,preS+numLeft,map);
        root.right=solve(pre,in,inRoot+1,e,preS+numLeft+1,preE,map);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       Map<Integer,Integer>map=new HashMap<>();
       for(int j=0;j<inorder.length;j+=1)
           map.put(inorder[j],j);
       return solve(preorder,inorder,0,inorder.length-1,0,preorder.length-1,map);
    }
}