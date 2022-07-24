class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n<=2)
          return n==1?nums[0]:Math.max(nums[0],nums[1]);
        int []dp=new int[n+2];
        dp[0]=nums[0];dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i+=1)
           dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        return dp[n-1];
    }
}