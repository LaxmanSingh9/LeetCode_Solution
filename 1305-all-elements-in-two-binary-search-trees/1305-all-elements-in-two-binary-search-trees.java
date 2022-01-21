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
    //Total TC=O(n1+n2)+O(n1)+O(n2)
    public void sortedBSTArr(TreeNode root,Queue<Integer>list){
        if(root==null){          
            return ; 
        }                             //O(n)
        sortedBSTArr(root.left,list); //Inorder trabesal,gives sorted list of node values
        list.offer(root.val);
        sortedBSTArr(root.right,list);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> list1=new LinkedList<>();
        sortedBSTArr(root1,list1);  //for first bst
        Queue<Integer> list2=new LinkedList<>();
        sortedBSTArr(root2,list2);//for second bst
        List<Integer>ans=new ArrayList<>();
        int i=0;int j=0;
        while(!list1.isEmpty() || !list2.isEmpty()){
          if(list1.isEmpty()){ans.add(list2.poll());}
          else if(list2.isEmpty()){ans.add(list1.poll());}
          else{ans.add(list1.peek()<list2.peek()?list1.poll():list2.poll());}
        }
        return ans;
    }
}