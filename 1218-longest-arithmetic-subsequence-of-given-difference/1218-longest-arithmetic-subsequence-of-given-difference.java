class Solution {
   public int longestSubsequence(int[] arr, int diff) {
        int ans=0;
        Map<Integer,Integer>map=new HashMap<>();
        for(int val:arr){
           map.put(val,1+map.getOrDefault(val-diff,0));
           ans=Math.max(ans,map.get(val)); 
        }
        return ans; 
       
    }
}