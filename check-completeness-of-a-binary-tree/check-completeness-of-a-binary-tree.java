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
    //TotalNodes have to be equal to the maximum index of node
    public int totalNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        return totalNodes(root.left)+totalNodes(root.right)+1;
    }
    public  boolean isCompleteTreeAns(TreeNode root,int currindex,int totalnodes){
        if(root==null){
            return true;
        }
        if(currindex>totalnodes){
            return false;
        }
        return isCompleteTreeAns(root.left,2*currindex,totalnodes)&&isCompleteTreeAns(root.right,2*currindex+1,totalnodes);
    }
    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTreeAns(root,1,totalNodes(root));
    }
    
}