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
    //Store all serlization of all the subress in the map
    //Traverse the whole map ,if value becomes more than 1 store into the resultant List
    public String serlizationofSubTrees(TreeNode root,Map<String,Integer>map,List<TreeNode>ans){
        if(root==null){
            return "#,";
        }
        String leftSubTree=serlizationofSubTrees(root.left,map,ans);
        String rightSubTree=serlizationofSubTrees(root.right,map,ans);
        String serial=root.val+","+leftSubTree+rightSubTree;
        map.put(serial,map.getOrDefault(serial,0)+1);
        if(map.get(serial)==2){ans.add(root);}
        return serial;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>ans=new ArrayList<TreeNode>();
        serlizationofSubTrees(root,new HashMap<>(),ans);
        return ans;
    }
}