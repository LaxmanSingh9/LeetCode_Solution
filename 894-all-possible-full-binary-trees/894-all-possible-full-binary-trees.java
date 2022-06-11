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
    
    public List<TreeNode> allPossibleFBTs(int N,Map<Integer,List<TreeNode>>map) {
        List<TreeNode> res = new ArrayList<>();
        if(N<=0 || N%2==0){
            return res;
        }
        if(map.get(N)!=null){
            return map.get(N);
        }
        if(N==1){
            res.add(new TreeNode(0));
            return res;
        }
        N=N-1;
        for(int i=1; i<=N;i+=2){
            List<TreeNode> left = allPossibleFBTs(i,map);
            List<TreeNode> right = allPossibleFBTs(N-i,map);
            for(TreeNode nl: left){
                for(TreeNode nr:right){
                    TreeNode cur = new TreeNode(0);
                    cur.left=nl;
                    cur.right=nr;
                    res.add(cur);
                }
            }
        }
        map.put(N+1,res);
        return res;
    }
    public List<TreeNode> allPossibleFBT(int N){
      Map<Integer,List<TreeNode>>map=new HashMap<>();
        return allPossibleFBTs(N,map);
        
        
        
    }
    
}