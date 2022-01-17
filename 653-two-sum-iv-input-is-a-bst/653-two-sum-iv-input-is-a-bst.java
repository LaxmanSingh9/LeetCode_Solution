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
     //Inorder Traversal that will provide sorted list
    public void inorder(TreeNode root,List<Integer>listOfNodeVal){
          if(root==null){
              return ;
          }
          inorder(root.left,listOfNodeVal);
          if(root!=null){
            listOfNodeVal.add(root.val);//Push the node val in list
          }
        
          inorder(root.right,listOfNodeVal);
        
    }
    
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> listOfNodeVal=new ArrayList<>();
        inorder(root,listOfNodeVal);
        //Two Pointer Method
        int l=0;int r=listOfNodeVal.size()-1;
        while(l!=r){
            if(listOfNodeVal.get(l)+listOfNodeVal.get(r)==k){
                return true;
            }
            else if(listOfNodeVal.get(l)+listOfNodeVal.get(r)>k){r-=1;}
            else{
                l+=1;
            }
        }
        return false;
        
        
        
         
        
    }
}