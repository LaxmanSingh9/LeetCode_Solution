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
    public TreeNode solution(int[]preorder,int[]inorder,Map<Integer,Integer>map,int s,int e,TreeNode  Index){
        if(s>e){
            return null;
        }
        int val=preorder[Index.val];
        Index.val+=1;
        int index=map.get(val);
        TreeNode node=new TreeNode(val);
        node.left=solution(preorder,inorder,map,s,index-1,Index);
        node.right=solution(preorder,inorder,map,index+1,e,Index);
        return node;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
         int inorder[] = Arrays.copyOfRange(preorder, 0, preorder.length);
        Arrays.sort(inorder);
        Map<Integer,Integer>map=new HashMap<>();
         for(int i=0;i<inorder.length;i+=1){
             map.put(inorder[i],i);
         }
        TreeNode Index=new TreeNode(0);
        
       // return null;
       return solution(preorder,inorder,map,0,inorder.length-1,Index);
    }
}