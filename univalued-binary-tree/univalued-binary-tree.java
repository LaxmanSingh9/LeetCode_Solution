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
    public boolean solution(TreeNode root,Set<Integer>set){
        if(root==null){
            return true;
        }
        set.add(root.val);
        if(set.size()>1){
            return false;
        }
        return solution(root.left,set)&&solution(root.right,set);
    }
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer>set=new HashSet<>();
        return solution(root,set);
        
    }
}