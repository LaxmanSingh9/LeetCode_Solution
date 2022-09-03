class Solution {
    public boolean canFindTargetSum(int []nums,int target){
          int n=nums.length;
          boolean [][]dp=new boolean[n+1][target+1];
          for(int i=0;i<n+1;i+=1)
            dp[i][0]=true;
          for(int j=1;j<target+1;j+=1)
            dp[0][j]=false;
          for(int i=1;i<n+1;i++){
             for(int j=1;j<target+1;j++){
                 if(j>=nums[i-1])
                     dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                 else
                      dp[i][j]=dp[i-1][j];
             } 
          }
          return dp[n][target];
          
    }
    public boolean canPartition(int[] nums) {
        int sumArr=0;
        for(int val:nums)
            sumArr+=val;
        if(sumArr%2==1)
            return false;
        return canFindTargetSum(nums,sumArr/2);
        
    }
}