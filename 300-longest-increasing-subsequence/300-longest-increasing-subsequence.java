class Solution {
  
   public int solve(int[]nums,int i,int prev,int[][]dp){
       if(i==nums.length)
          return 0;
       if(prev!=-1 && dp[i][prev]!=-1)
          return dp[i][prev];
       int exculde=solve(nums,i+1,prev,dp);
       int include=0;
       if(prev==-1 || nums[i]>nums[prev])
          include=1+solve(nums,i+1,i,dp);
       if(prev!=-1)
          dp[i][prev]=Math.max(exculde,include);
       return Math.max(exculde,include);
   }
   public int lengthOfLIS(int[] nums){
        int [][]dp=new int[nums.length+1][nums.length+1];
        for(int []ar:dp){
            Arrays.fill(ar,-1);
        }
        return   solve(nums,0,-1,dp);
   }
}