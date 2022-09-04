class Solution {
    public boolean canFindTargetSum(int []nums,int target){
          int n=nums.length;
          boolean [][]dp=new boolean[n+1][target+1];
          dp[0][0]=true;
          for(int i=1;i<n+1;i++){
             dp[i][0]=true; 
             for(int j=1;j<target+1;j++){
                 if(j>=nums[i-1])  //include & skip
                     dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                 else
                    dp[i][j]=dp[i-1][j];//skip 
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