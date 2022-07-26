class Solution {
    public int calSumOfArr(int []ar){
        int ans=0;
        for(int val:ar)
            ans+=val;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sumOfArr=calSumOfArr(nums);
          if ((sumOfArr & 1) == 1)
              return false;
    
        int n=nums.length,target=sumOfArr/2;
        boolean [][]dp=new boolean[n+1][target+1];
        for(int i=0;i<n+1;i+=1)
            dp[i][0]=true;
        for(int j=1;j<target+1;j+=1)
            dp[0][j]=false;
        for(int i=1;i<n+1;i+=1){
            for(int j=1;j<target+1;j+=1){
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1])
                  dp[i][j]=(dp[i][j] || dp[i-1][j-nums[i-1]]);
            }
        }
        return dp[n][target];
    }
}














