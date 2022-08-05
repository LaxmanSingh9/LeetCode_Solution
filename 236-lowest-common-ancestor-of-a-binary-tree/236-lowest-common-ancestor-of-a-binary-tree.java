/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode  solve(TreeNode  root,TreeNode p,TreeNode q){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        parent.put(root,null);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node=queue.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                queue.add(root.left);
            }
            if(node.right!=null){
               parent.put(node.right,node);
               queue.add(root.right);
            }
             
        }
        Set<TreeNode>set=new HashSet<>();
        while(p!=null){
            set.add(p);
            p=parent.get(p);
        }
        while(!set.contains(q)){
            q=parent.get(q);
        }
        return q;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root.val==p.val || root.val==q.val)
            return root;
        
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null &&right!=null)
          return root;
        return left==null?right:left;
        
    }
}