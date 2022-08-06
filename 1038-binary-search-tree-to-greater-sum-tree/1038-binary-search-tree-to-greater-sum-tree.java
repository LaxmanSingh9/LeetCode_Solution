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
    int sum=0;
    public TreeNode bfs(TreeNode root){
       Stack<TreeNode>stack=new Stack<>();
       int sum=0;
       TreeNode curr=root;
       while(curr!=null || !stack.isEmpty()) {
           while(curr!=null){
               stack.push(curr);
               curr=curr.right;
           }
           curr=stack.pop();
           //System.out.println(curr.val);
           sum+=curr.val;
           curr.val=sum;
           
           curr=curr.left;
       }
       return root;    
    }
    public void solve(TreeNode root){
        if(root==null){return ;}
        solve(root.right);
        sum+=root.val;
        root.val=sum;
        solve(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
      bfs(root);
      return root;
        
    }
}