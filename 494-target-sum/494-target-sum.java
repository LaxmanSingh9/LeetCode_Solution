class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0,n=nums.length;
        for(int val:nums)sum+=val;
        if((target+sum)%2!=0 || Math.abs(target)>sum)return 0;
        target=(sum+target)/2;
        int [][]dp=new int[n+1][target+1];
        dp[0][0]=1;
        for(int j=1;j<target+1;j+=1)
          dp[0][j]=0;
        for(int i=1;i<n+1;i+=1){
          for(int j=0;j<target+1;j+=1){
              if(nums[i-1]<=j)
                 dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
              else
                 dp[i][j]=dp[i-1][j];
          }
        }
        //System.out.println(dp[0][0]+" "+dp[0][1]);
        return dp[n][target];
        
        
    }
}