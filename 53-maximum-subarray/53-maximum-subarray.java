class Solution {
    public int maxSubArray(int[] nums) {
         int n=nums.length; 
         int []dp=new int [n+1];
         dp[0]=0;int ans=Integer.MIN_VALUE;
         for(int i=1;i<=n;i+=1){
             dp[i]=Math.max(dp[i-1]+nums[i-1],nums[i-1]);
             ans=Math.max(ans,dp[i]);
         }
         return ans;
        
        
        
    }
}