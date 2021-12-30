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
    StringBuilder result = new StringBuilder();
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLca(root, startValue, destValue);
        findPath(lca, startValue, new StringBuilder(), true);
        findPath(lca, destValue, new StringBuilder(), false);
        return result.toString();
    }
    
    public TreeNode findLca(TreeNode root, int p, int q) {
        if (root == null) {
            return root;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = findLca(root.left, p, q);
        TreeNode right = findLca(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    
    public boolean findPath(TreeNode root, int value, StringBuilder sb, boolean isStart) {
        if (root == null) {
            return  false;
        }
        if (root.val == value) {
            System.out.println(sb.toString());
            result.append(sb);
            return true;
        }
        boolean left=findPath(root.left,value,isStart?sb.append("U"):sb.append("L"), isStart);
        if(left==true){
            return true;
        }
        sb.setLength(sb.length() - 1);
        boolean right=findPath(root.right,value,isStart?sb.append("U"):sb.append("R"), isStart);
        if(right==true){
            return true;
        }
        sb.setLength(sb.length() - 1);
        return false;
    }
}