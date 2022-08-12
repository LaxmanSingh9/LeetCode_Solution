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
    public void solve(TreeNode root,int level){
        if(root==null){return ;}
        map.put(level,root.val+map.getOrDefault(level,0));
        solve(root.left,level+1);
        solve(root.right,level+1);
    }
    public int maxLevelSum(TreeNode root) {
        int levl=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        solve(root,1);
        for(Map.Entry<Integer,Integer>m:map.entrySet()){
           if(m.getValue()>max){
                max=m.getValue();
                levl=m.getValue()==m.getKey()?Math.min(m.getKey(),levl):m.getKey();
            }
        }
        return levl;
    }
}