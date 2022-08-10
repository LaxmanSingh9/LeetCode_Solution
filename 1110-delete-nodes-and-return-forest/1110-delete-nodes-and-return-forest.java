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
    public TreeNode solve(TreeNode root,Map<Integer,Integer>map){
        if(root==null){return null;}
        TreeNode left=solve(root.left,map);
        TreeNode right=solve(root.right,map);
        if(map.containsKey(root.val)){
            if(left!=null)
              ans.add(left);
            if(right!=null)
              ans.add(right);
            return null;
        }
        root.left=left;root.right=right;
        return root;
        
    } 
        
        
        
    public List<TreeNode> delNodes(TreeNode root, int[] ar) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int a:ar)
            map.put(a,a);
        root=solve(root,map);
        if(root!=null)ans.add(root);
        return ans;
    }
}




















