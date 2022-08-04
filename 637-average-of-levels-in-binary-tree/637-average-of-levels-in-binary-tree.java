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
    Map<Integer,List<Double>>map=new HashMap<>();
    public void solve(TreeNode root,int level){
        if(root==null){
            return  ;
        }
        double d=root.val;
        List<Double>l=new ArrayList<>();
        if(map.containsKey(level)){
            l=map.get(level);
            l.add(d);
            map.put(level,l);
        }
        if(!map.containsKey(level)){
            l.add(d);
            map.put(level,l);
        }
        solve(root.left,level+1);
        solve(root.right,level+1);
    }
    
    public List<Double> averageOfLevels(TreeNode root) {
        solve(root,0);
        double sum=0f;
        List<Double>ans=new ArrayList<>();
        for(List<Double>list:map.values()){
           for(double val:list)
                sum+=val;
            ans.add(sum/(list.size()));
            sum=0f;
        }
        return ans;
    }
}