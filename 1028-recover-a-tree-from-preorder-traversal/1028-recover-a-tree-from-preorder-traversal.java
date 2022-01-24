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
    public TreeNode recoverFromPreorder(String traversal) {
             int index=0;
             Map<Integer,TreeNode>map=new HashMap<>();
             while(index!=traversal.length()){
                 int level=0;int curNum=0;
                 while(traversal.length()>index&&traversal.charAt(index)=='-'){
                     level+=1;
                     index+=1;
                 }
                 while(traversal.length()>index&&traversal.charAt(index)!='-'){
                      curNum = curNum*10 + (traversal.charAt(index) - '0');
                      index+=1;
                 }
                 TreeNode curNode=new TreeNode(curNum);
                 map.put(level,curNode);
                 if(level>0){
                     TreeNode parent=map.get(level-1);
                     if(parent.left==null){parent.left=curNode;}
                     else{parent.right=curNode;}
                 }                 
                  
           }
           return map.get(0);
    }
}