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
    int maxWidth=0;
    List<Integer>arr=new ArrayList<>();
    public void solve(TreeNode root,int node,int depth){
        if(root==null){return ;}
        if(arr.size()==depth)
          arr.add(node);
        maxWidth=Math.max(maxWidth,node-arr.get(depth)+1);
        solve(root.left,2*node+1,depth+1);
        solve(root.right,2*node+2,depth+1);
        
    }
    public int widthOfBinaryTree(TreeNode root) {
        solve(root,0,0);
        return maxWidth;
    }
}