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
    List<Integer>list=new ArrayList<>();
    public void populate(TreeNode curr,Stack<TreeNode>stack){
        while(curr!=null){
            stack.push(curr);
            curr=curr.left;
         }
    }
    public List<Integer> solve(TreeNode root1,TreeNode root2){
        Stack<TreeNode>stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();
        List<Integer>ans=new ArrayList<>();
        populate(root1,stack1);
        populate(root2,stack2);
        TreeNode curr=null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
           if(stack1.peek().val<stack2.peek().val){
                TreeNode tempcurr=stack1.pop();
                ans.add(tempcurr.val);
                curr=tempcurr.right;
                populate(curr,stack1);
            }
            else{
                TreeNode tempcurr=stack2.pop();
                ans.add(tempcurr.val);
                curr=tempcurr.right;
                populate(curr,stack2);
            }
        }
        Stack<TreeNode>stack=stack1.isEmpty()?stack2:stack1;
        while(!stack.isEmpty()){
            curr=stack.pop();
            ans.add(curr.val);
            populate(curr.right,stack);
        }
        return ans;
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
       return solve(root1,root2);
    }
}