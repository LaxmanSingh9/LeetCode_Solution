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
    public TreeNode solve(TreeNode root,int val){
        TreeNode curr=root;
        TreeNode parent=null;
        while(curr!=null){
            parent=curr;
            if(curr.val>val)
                curr=curr.left;
            else
              curr=curr.right;
        }
        if(parent.val>val)
          parent.left=new TreeNode(val);
        else
          parent.right=new TreeNode(val);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
       int len=preorder.length;
       TreeNode root=new TreeNode(preorder[0]);
       for(int i=1;i<preorder.length;i+=1)
           solve(root,preorder[i]);
       return root;
    }
}









