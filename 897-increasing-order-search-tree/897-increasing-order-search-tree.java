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
    List<Integer>list=new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null)return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);TreeNode ans=new TreeNode(0);TreeNode curr;
        curr=ans;
        for(int i=0;i<list.size();i+=1){
            curr.right=new TreeNode(list.get(i));
            curr=curr.right;
            
        }
        return ans.right;
    } 
}