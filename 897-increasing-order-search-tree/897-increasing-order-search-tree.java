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
    TreeNode currNode;
    List<TreeNode>list=new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        list.add(root);
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        for(int i=0;i<list.size()-1;i+=1){
            list.get(i+1).left=null;
            list.get(i).right=list.get(i+1);
            
        }
        return list.get(0);
    } 
}