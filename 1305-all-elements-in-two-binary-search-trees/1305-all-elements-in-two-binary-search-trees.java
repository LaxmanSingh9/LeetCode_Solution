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
    public void sortedBSTArr(TreeNode root,List<Integer>list){
        if(root==null){          
            return ; 
        }                             //O(n)
        sortedBSTArr(root.left,list); //Inorder trabesal,gives sorted list of node values
        list.add(root.val);
        sortedBSTArr(root.right,list);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=new ArrayList<>();
        sortedBSTArr(root1,list1);  //for first bst
        List<Integer> list2=new ArrayList<>();
        sortedBSTArr(root2,list2);//for second bst
        List<Integer>ans=new ArrayList<>();
        int i=0;int j=0;
        while(i<list1.size()&&j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                ans.add(list1.get(i));i+=1;      //mergeing both list O(n1+n2)
            }                                    
            else if(list1.get(i)>list2.get(j)){
                ans.add(list2.get(j));j+=1;
             }
             else{ans.add(list1.get(i));ans.add(list1.get(i));i+=1;j+=1;}
        }
        while(i<list1.size()){ans.add(list1.get(i));i+=1;}
        while(j<list2.size()){ans.add(list2.get(j));j+=1;}
        return ans;
    }
}