class Solution{
    public int totalWaysSumUptoTarget(int []nums,int target){
        int n=nums.length;
        int []dp=new int[target+1];
        dp[0]=1;
        for(int j=1;j<target+1;j++){
           for(int i=0;i<n;i++){
               if(j>=nums[i])
                  dp[j]+=dp[j-nums[i]]; 
           } 
        }
        return dp[target];
    }
    public int combinationSum4(int[] nums, int target) {    
        return totalWaysSumUptoTarget(nums,target);
    }
}