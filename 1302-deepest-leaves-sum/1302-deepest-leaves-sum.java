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
    Map<Integer,Integer>map=new HashMap<>();
    int maxLevel=-1,sum=0;
    public void solve(TreeNode root ,int level){
        if(root==null){return;}
        if(level>maxLevel){
            sum=0;maxLevel=level;
        }
        if(level==maxLevel){
            sum+=root.val;
        }
        solve(root.left,level+1);
        solve(root.right,level+1);
        
    }
    public int deepestLeavesSum(TreeNode root) {
        solve(root,0);
        return sum;
        
    }
}