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
    public TreeSet<Integer>set=new TreeSet<>();
    int min=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        }
        if(set.isEmpty()==false){
            if(set.floor(root.val)!=null){
                min=Math.min(min,root.val-set.floor(root.val));
            }
            if(set.ceiling(root.val)!=null){
                min=Math.min(min,set.ceiling(root.val)-root.val);
            }
        }
        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        return min;
    }
}









