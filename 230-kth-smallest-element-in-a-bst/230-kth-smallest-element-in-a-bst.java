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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode>stack=new Stack<TreeNode>();
        TreeNode buffer=root;int count=0;
        int ans=-1;
        while(buffer!=null || ans==-1|| !stack.isEmpty()){
            if(buffer!=null){
                stack.push(buffer);
                buffer=buffer.left;
            }
            else{
                 buffer=stack.pop();
                if(++count==k){
                    ans=buffer.val;
                }
                buffer=buffer.right;
            }
            
        }
        return ans;
    }
}