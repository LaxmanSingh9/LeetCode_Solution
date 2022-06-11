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
    public Map<Integer,List<TreeNode>>map=new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
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
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N-i);
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
}