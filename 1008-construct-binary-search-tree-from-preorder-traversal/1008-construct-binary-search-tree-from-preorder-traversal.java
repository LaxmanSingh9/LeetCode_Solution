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
    public TreeNode solution(int[] preorder,int s,int e){
        if(s>e){return null;}
        int val=preorder[s];
        TreeNode node=new TreeNode(val);
        int i;
        for(i=s;i<=e;i+=1){
           if(preorder[i]>val){
               break;
           }
        }
        node.left=solution(preorder,s+1,i-1);
        node.right=solution(preorder,i,e);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return solution(preorder,0,preorder.length-1);
    }
}