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
    List<TreeNode>ans=new ArrayList<>();
     public List<TreeNode> solve(TreeNode root,Map<Integer,Integer>map){
        if(root==null)return ans;
        Queue<TreeNode>q=new LinkedList<>();
        if(!map.containsKey(root.val)){
            ans.add(root);
        }
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node=q.poll();
            if(node.left!=null) {
                q.add(node.left);
                if(map.containsKey(node.left.val))
                  node.left=null;
              
            }
            if(node.right!=null) {
                q.add(node.right);
                if(map.containsKey(node.right.val))
                  node.right=null;
            }
            if(map.containsKey(node.val)){
                if(node.left!=null)
                  ans.add(node.left);
                if(node.right!=null)
                 ans.add(node.right);
                node=null;
            }
        }
        
        return ans;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] ar) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int a:ar)
            map.put(a,a);
        return solve(root,map);
    }
}




















