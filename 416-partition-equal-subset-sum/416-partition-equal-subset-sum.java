class Solution {
    public boolean canFindTargetSum(int []nums,int target){
          int n=nums.length;
          boolean []dp=new boolean[target+2];
          dp[0]=true;
          for(int val:nums){
              for(int j=target;j>=val;j--){
                 dp[j]=dp[j]||dp[j-val];
             } 
          }
          return dp[target];
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