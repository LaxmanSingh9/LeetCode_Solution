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
    public TreeNode solve(TreeNode root1,TreeNode root2){
          if(root1==null){return root2;}
          if(root2==null){return root1;}
          Queue<TreeNode>q1=new LinkedList<>();
          Queue<TreeNode>q2=new LinkedList<>();
          q1.add(root1);q2.add(root2);
          while(q1.size()>0 || q2.size()>0){
              TreeNode node1=q1.poll();
              TreeNode node2=q2.poll();
              node1.val+=node2.val;
              if(node1.left!=null && node2.left!=null){
                  q1.add(node1.left);q2.add(node2.left);
              }
              else if(node2.left!=null) {
                  node1.left=node2.left;
              }
              if(node1.right!=null && node2.right!=null){
                  q1.add(node1.right);q2.add(node2.right);
              }
              else if(node2.right!=null){
                  node1.right=node2.right;
              }
                  
                  
              
          }
          return root1;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return  solve(root1,root2);
    }
}