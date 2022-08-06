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
    Map<Integer,Integer>map=new HashMap<>();
    public int maxInt(int nums[] ,int l ,int r){
        int max=-1,index=0;
        for(int i=l;i<=r;i+=1){
            if(nums[i]>max){
                max=nums[i];index=i;
            }
              
        }
        return index;
    }
    public TreeNode solve(int [] nums,int l ,int r){
         if(l>r){
            return null;
        }
        int i=maxInt(nums,l,r);
        TreeNode node=new TreeNode(nums[i]);
        node.right=solve(nums,i+1,r);
        node.left=solve(nums,l,i-1);
        
        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums,0,nums.length-1);    
    }
}