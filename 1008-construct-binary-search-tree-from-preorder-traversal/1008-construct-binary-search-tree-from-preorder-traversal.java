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
    
    //Inserting in an BST(O(h))
    public TreeNode insert(TreeNode root,int val){
        if(root==null){return new TreeNode(val);}
        else if(root.val>val){root.left=insert(root.left,val);}
        else if(root.val<val){root.right=insert(root.right,val);}
        return root;
        
    }
    //Total TC=O(n*h)
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        //O(n)
        for(int val:preorder){
            root=insert(root,val);
        }
        return root;
    }
}