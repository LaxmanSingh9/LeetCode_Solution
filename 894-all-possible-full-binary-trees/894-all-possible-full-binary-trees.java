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
    Map<Integer,List<TreeNode>>map=new HashMap<>();
    public List<TreeNode>solve(int N){
        List<TreeNode>res=new ArrayList<>();
        if(N<=0 || N%2==0){
            return res;
        }
        if(map.containsKey(N)){
            return map.get(N);
        }
        if(N==1){
           TreeNode node=new TreeNode(0);res.add(node);
           return res;
        }
        N=N-1;
        for(int i=1;i<=N;i+=2){
           List<TreeNode>left=solve(i);
           List<TreeNode>right=solve(N-i);
           for(TreeNode nl:left){
              for(TreeNode nr:right){
                 TreeNode curr=new TreeNode(0);
                 curr.left=nl;
                 curr.right=nr;
                 res.add(curr);
                  
              } 
           }
            
        }
        map.put(N+1,res);
        return res;
    }
    public List<TreeNode> allPossibleFBT(int n) {
       return solve(n);
    }
}








