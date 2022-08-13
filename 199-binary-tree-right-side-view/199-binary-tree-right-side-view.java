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
    List<Integer>ans=new ArrayList<>();
    public void solve(TreeNode root,int d){
       if(root==null){return;}
       if(ans.size()>=d+1){ans.set(d,root.val);}
       else{ans.add(root.val);}
       solve(root.left,d+1);
       solve(root.right,d+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        solve(root,0);
        return ans;
    }
}