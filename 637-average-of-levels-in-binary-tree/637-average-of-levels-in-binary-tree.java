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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        List<Double>ans=new ArrayList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()) {
            int width=q.size();
            double sum=0f;int totalNodes=width;
            while(width-->0){
               TreeNode node=q.poll();
               sum+=node.val;
               if(node.left!=null)
                  q.offer(node.left);
               if(node.right!=null)
                  q.offer(node.right);
            }
            ans.add(sum/totalNodes);
        }
        return ans;
        
    }
}