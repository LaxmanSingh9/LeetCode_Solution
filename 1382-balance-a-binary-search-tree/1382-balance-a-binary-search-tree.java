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
    private List<Integer>sortedArr=new ArrayList<>();
    public void  inOrderTrevarsal(TreeNode root){
        if(root==null)return ;
        inOrderTrevarsal(root.left);
        sortedArr.add(root.val);
        inOrderTrevarsal(root.right);
    }
    public TreeNode createBSTFromArr(List<Integer>sortArr,int l,int r){
        if(l>r)return null;
        int mid=(l+r)/2;
        TreeNode node=new TreeNode(sortArr.get(mid));
        node.left=createBSTFromArr(sortArr,l,mid-1);
        node.right=createBSTFromArr(sortArr,mid+1,r);
        return node;
        
    }
    public TreeNode balanceBST(TreeNode root) {
        inOrderTrevarsal(root);
        return createBSTFromArr(sortedArr,0,sortedArr.size()-1);
    }
}