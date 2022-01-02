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
    public int solution(TreeNode root,StringBuilder sum,int[]totalSum){
        if(root==null){
            return -1;
        }
        sum.append(root.val);
        int left=solution(root.left,sum,totalSum);
        int right=solution(root.right,sum,totalSum);
        if(left==-1 && right==-1){
           totalSum[0]+=Integer.parseInt(sum.toString());
        }

        sum.setLength(sum.length() - 1);
        return left+right;
        
        
    }
    public int sumNumbers(TreeNode root) {
        int totalSum[]=new int[1];
        solution(root,new StringBuilder(),totalSum);
        return totalSum[0];
   }
}