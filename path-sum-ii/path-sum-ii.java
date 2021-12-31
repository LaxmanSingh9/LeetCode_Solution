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
    public void solution(TreeNode root,List<Integer> list,List<List<Integer>>ans,int tv,int val){
        
        if(root!=null && root.left==null && root.right==null){
             list.add(root.val);
             if(val+root.val==tv){
                List<Integer>l=new ArrayList<>();
                for(int j:list){
                    l.add(j);
                }
                ans.add(l);
             }
            return;
         }
        
        list.add(root.val);
        if(root.left!=null){
            solution(root.left,list,ans,tv,val+root.val);
             list.remove(list.size() - 1);
        }
        
       
        if(root.right!=null){
            solution(root.right,list,ans,tv,val+root.val);
            list.remove(list.size() - 1);
        }
        
       
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         if(root==null){
             return new ArrayList<>();
         }
         List<List<Integer>>ans=new ArrayList<>();
         solution(root,new ArrayList(),ans,targetSum,0);
         return ans;
    }
}