class Solution {
    public int maxSubArray(int[] nums) {
         int n=nums.length; 
         int prev=0,curr=0;
         int ans=Integer.MIN_VALUE;
         for(int i=0;i<n;i+=1){
             curr=Math.max(prev+nums[i],nums[i]);
             ans=Math.max(ans,curr);
             prev=curr;
         }
         return ans;
        
        
        
    }
}