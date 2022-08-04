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
    Map<Integer,double[]>map=new HashMap<>();
    public void solve(TreeNode root,int level){
        if(root==null){
            return;
        }
        double d=root.val;
        double l[]=new double[2];
        if(map.containsKey(level)){
            l=map.get(level);
            l[0]+=d;l[1]+=1;
        }
        if(!map.containsKey(level)){
            l[0]+=d;l[1]+=1;
        }
        map.put(level,l);
        solve(root.left,level+1);
        solve(root.right,level+1);
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        solve(root,0);
        List<Double>ans=new ArrayList<>();
        for(double []ar:map.values()){
           ans.add(ar[0]/ar[1]);
        }
        return ans;
    }
}