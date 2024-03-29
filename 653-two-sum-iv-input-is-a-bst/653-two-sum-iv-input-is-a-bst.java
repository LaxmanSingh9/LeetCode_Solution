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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){return false;}
        if(map.containsKey(root.val)){return true;}
        map.put(k-root.val,1);
        return findTarget(root.left,k) || findTarget(root.right,k);
        
    }
}