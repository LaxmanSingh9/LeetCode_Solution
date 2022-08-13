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
import java.util.*;
class Solution {
    Map<Integer,Integer>map=new HashMap<>();
    int maxFreq=Integer.MIN_VALUE;
    public int solve(TreeNode root){
        int left=0,right=0;
        if(root.left!=null){
            left=solve(root.left); 
            map.put(left,map.getOrDefault(left,0)+1);
            maxFreq=Math.max(maxFreq,map.get(left));
            
        }
        if(root.right!=null){
            right=solve(root.right);
            map.put(right,map.getOrDefault(right,0)+1);
            maxFreq=Math.max(maxFreq,map.get(right));
        }
        return root.val+left+right;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        int sum=solve(root),maxFreqCnt=0;
        List<Integer>ans=new ArrayList<>();
        map.put(sum,map.getOrDefault(sum,0)+1);
        maxFreq=Math.max(maxFreq,map.get(sum));
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq)
              ans.add(key);
        
        }
        int[] arr=new  int[ans.size()];
        for(int i=0;i<ans.size();i+=1){
            arr[i]=ans.get(i);
        }
        return arr;
    }
}