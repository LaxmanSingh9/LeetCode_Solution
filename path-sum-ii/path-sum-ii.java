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
    public void solution(TreeNode root,String list,List<List<Integer>>ans,int tv,int val){
        if(root!=null && root.left==null && root.right==null){
           list=list+","+root.val;val+=root.val;
           if(val==tv){
             
              List<Integer>l=new ArrayList<>();
              for(String s:list.split(",")){
                 if(s.length()>0){
                     l.add(Integer.parseInt(s));}
              }
              ans.add(l);}
          return;
        }
        if(root==null){
            return;
        }
        solution(root.left,list+","+root.val,ans,tv,val+root.val);
        solution(root.right,list+","+root.val,ans,tv,val+root.val);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>>ans=new ArrayList<>();
         solution(root,"",ans,targetSum,0);
         return ans;
    }
}