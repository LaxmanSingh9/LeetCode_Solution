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
    public void solve(TreeNode root ,int level){
        if(root==null){return;}
        map.put(level,map.getOrDefault(level,0)+root.val);
        solve(root.left,level+1);
        solve(root.right,level+1);
        
    }
    public int deepestLeavesSum(TreeNode root) {
        int deepestLevel=0,ans=0;
        solve(root,0);
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
            if(m.getKey()>=deepestLevel){
               deepestLevel=m.getKey();ans=m.getValue();
            }
        }
        return ans;
        
    }
}