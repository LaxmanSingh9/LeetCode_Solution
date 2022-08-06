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
    public int findNextBiggerEle(int []nums,int l,int r){
        int max=nums[l],index=r+1,i;
        for(i=l;i<=r;i+=1){
            if(nums[i]>max){
               index=i;break;
            }
        }
        return i;
       
        
    }
    public TreeNode solve(int []pre,int l,int r){
        if(l>r){return null;}
        TreeNode node=new TreeNode(pre[l]);
        int i=findNextBiggerEle(pre,l,r);
        node.left=solve(pre,l+1,i-1);
        node.right=solve(pre,i,r);
        return node;
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
       int len=preorder.length;
       return solve(preorder,0,len-1);
    }
}