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
    public void solution(TreeNode root,int depth,int d,int val){
        
        if(depth-1==d &&root!=null){
            ///System.out.println(root.val+" "+d);
            TreeNode nodeval=new TreeNode(val);
            nodeval.left=root.left!=null?root.left:null;
            TreeNode nodeval1=new TreeNode(val);
            nodeval1.right=root.right!=null?root.right:null;
            root.left=nodeval;
            root.right=nodeval1;
           return;
        }
        if(root==null){
            return ;
        }
        solution(root.left,depth,d+1,val);
        solution(root.right,depth,d+1,val);
        //return root;
        
        
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth){
        if(depth==1){
            TreeNode  newnode=new TreeNode(val);
            newnode.left=root;
            return newnode;
        }
        solution(root,depth-1,0,val);
        return root;
    }
}