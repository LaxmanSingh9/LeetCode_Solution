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
class Solution{
    //Using divide and conquer to contrcut the bal BST3
    public TreeNode MakeBalBSTFromSortedList(int s,int e,List<TreeNode>sortBSTArr){
        if(s>e){return null;}
        int mid=(s+e)/2;
        TreeNode node=sortBSTArr.get(mid);
        node.left=MakeBalBSTFromSortedList(s,mid-1,sortBSTArr);
        node.right=MakeBalBSTFromSortedList(mid+1,e,sortBSTArr);
        return node;
        
        
    }
    //Get the sort arr from inorder traversal of bst
    public void GetSortedBSTList(TreeNode root,List<TreeNode>sortBSTArr){
        if(root==null){return ;}
        GetSortedBSTList(root.left,sortBSTArr);
        sortBSTArr.add(root);
        GetSortedBSTList(root.right,sortBSTArr);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode>sortBSTArr=new ArrayList<>();
        GetSortedBSTList(root,sortBSTArr) ;//GET THE SORTED ARRAY
        return MakeBalBSTFromSortedList(0,sortBSTArr.size()-1,sortBSTArr);//return root
    }
}