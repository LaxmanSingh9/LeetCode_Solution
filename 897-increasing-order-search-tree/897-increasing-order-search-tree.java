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
    public void increasingBST1(TreeNode root,List<Integer>arr) {
        if(root==null){
            return ;
        }
        increasingBST1(root.left,arr);
        if(root!=null){
            arr.add(root.val);
        }
        increasingBST1(root.right,arr);
        
        
    }
    public TreeNode increasingBST(TreeNode root){
       List<Integer>arr=new ArrayList<>();
       increasingBST1(root,arr);
       TreeNode node=new TreeNode(0);TreeNode ans=node;
       for(int val:arr){
            node.right=new TreeNode(val);
            node=node.right;
               
       }
       return ans.right; 
    }
}