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
    private int mod=1000000007;
    private long ans=0;
    public void refineAns(long sum,int s1){
        ans=Math.max(ans,((sum-s1)*s1));
    }
    public long totalTreeSum(TreeNode root){
        if(root==null)
           return 0;
        return root.val+totalTreeSum(root.left)+totalTreeSum(root.right);
    }
    public int solve(TreeNode root,long sum){
        if(root==null)
           return 0;
        int left=solve(root.left,sum);
        refineAns(sum,left);
        int right=solve(root.right,sum);
        refineAns(sum,right);
        return root.val+left+right;
    }
    public int maxProduct(TreeNode root) {
        solve(root,totalTreeSum(root));
        return (int) (ans % (1e9+7));
    }
}





















