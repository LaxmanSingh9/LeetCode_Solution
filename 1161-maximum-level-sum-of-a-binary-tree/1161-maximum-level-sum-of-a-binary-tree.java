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
    public int solve(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int level=1,max=Integer.MIN_VALUE,levl=0,sum=0;
        while(!q.isEmpty()) {
            int si=q.size();
            levl+=1;sum=0;
            while(si>0){
                TreeNode node=q.poll();
                sum+=node.val;
                if(node.left!=null)
                  q.add(node.left);
                if(node.right!=null)
                  q.add(node.right);
                si-=1;
            }
            if(sum>max){
              max=sum;level=levl; 
            }
              
        }
        return level;
    }
    public int maxLevelSum(TreeNode root) {
        return solve(root);
    }
}