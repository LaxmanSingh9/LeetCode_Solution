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
    public boolean solution(TreeNode root,int level,List<Integer>ar){
        if(root==null){
            return true;
        }
        else if(root.val%2==level%2){
            return false;
        }
       else if(ar.size()==level){
             ar.add(root.val);
        }
        else if(level%2==0 && root.val<=ar.get(level)){
            return false;
        }
        else if(level%2==1 && root.val>=ar.get(level)){
            return false;
        }
        else{ar.set(level,root.val);}
        return solution(root.left,level+1,ar)&&solution(root.right,level+1,ar);
        
        
    }
    public boolean isEvenOddTree(TreeNode root) {
        return solution(root,0,new ArrayList<>());
    }
}