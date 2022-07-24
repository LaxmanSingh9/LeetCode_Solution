class Solution {
    public int solve(int l ,int r, int[] nums){
          int dp[]=new int[nums.length+1];
          dp[l]=nums[l];dp[l+1]=Math.max(nums[l],nums[l+1]);
          for(int i=l+2;i<=r;i+=1)
              dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        
          return dp[r];
        
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        return Math.max(solve(0,n-2,nums),solve(1,n-1,nums));
    }
}