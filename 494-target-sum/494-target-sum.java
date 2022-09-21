class Solution {
  public int solve(int []arr,int target){
      int n=arr.length;  
      int [][]dp=new int[n+1][target+1];
      for(int i=0;i<n+1;i++)
         dp[i][0]=0;
      for(int i=0;i<target+1;i++)
         dp[0][i]=0;
      dp[0][0]=1;
      for(int i=1;i<n+1;i++){
        for(int j=0;j<target+1;j++){
           dp[i][j]+=dp[i-1][j];
           if(j>=arr[i-1])
             dp[i][j]+=dp[i-1][j-arr[i-1]];  
        }  
      }
      return dp[n][target];  
        
    }
    public int findTargetSumWays(int[] nums, int target) {
      int sum=0;
      for(int val:nums)
          sum+=val; 
      if((target+sum)%2!=0 || Math.abs(target)>sum)return 0;
      target=(sum+target)/2;
      return solve(nums,target);    
    }
}