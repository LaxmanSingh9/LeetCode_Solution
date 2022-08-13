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
public void solve(TreeNode root,int d,List<Integer>ans){
        if(root==null){return;}
        if(ans.size()>=d+1 && ans.get(d)<root.val)ans.set(d,root.val);
        else if(ans.size()<d+1) ans.add(root.val);
        solve(root.left,d+1,ans);
        solve(root.right,d+1,ans);
    }
    public List<Integer> largestValues(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        solve(root,0,ans);
        return ans;
    }
}