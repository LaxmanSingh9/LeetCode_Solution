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
    private int answer=0;
    public void solve(TreeNode root,int ans,int path){
        if(root==null){return ;}
        answer=Math.max(answer,ans);
        solve(root.left,(path==0?0:ans)+1,0);//0-left
        solve(root.right,(path==1?0:ans)+1,1);//1-right
    }
    public int longestZigZag(TreeNode root) {
      solve(root,0,-1);
      return answer;
    }
}