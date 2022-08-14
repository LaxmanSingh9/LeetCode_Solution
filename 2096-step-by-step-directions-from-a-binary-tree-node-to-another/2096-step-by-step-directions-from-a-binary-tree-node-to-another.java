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
    public TreeNode lca(TreeNode root,int startValue,int endValue){
        if(root==null)
            return null;
        if(root.val==startValue)
            return root;
        if(root.val==endValue)
            return root;
        TreeNode left=lca(root.left,startValue,endValue);
        TreeNode right=lca(root.right,startValue,endValue);
        if(left!=null && right!=null)
           return root;
        return left!=null?left:right;
    }
    public String findPath(TreeNode root,int target,StringBuilder path,boolean toParent){
          if(root==null){return "";}
          if(root.val==target){return path.toString();}
          String left=findPath(root.left,target,path.append(toParent?"U":"L"),toParent);
          path.setLength(path.length()-1);
          String right=findPath(root.right,target,path.append(toParent?"U":"R"),toParent);
          path.setLength(path.length()-1);
          return left.length()==0?right:left;
        
    }
    public String getDirections(TreeNode root, int startValue, int endValue) {
        TreeNode lcaNode=lca(root,startValue,endValue);
        String toParent=findPath(lcaNode,startValue, new StringBuilder(),true);
        String fromParent=findPath(lcaNode,endValue, new StringBuilder(),false);
        if(lcaNode.val==startValue)
            return fromParent;
        if(lcaNode.val==endValue)
            return toParent;
        return toParent+fromParent;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}