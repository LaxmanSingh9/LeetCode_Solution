class Solution{
    public int totalWaysSumUptoTarget(int []nums,int target){
        int n=nums.length;
        Arrays.sort(nums);
        int []dp=new int[target+1];
        dp[0]=1;
        for(int j=1;j<target+1;j++){
           for(int num:nums){
               if(j>=num)
                  dp[j]+=dp[j-num]; 
               else
                  break; 
           } 
        }
        return dp[target];
    }
    public int combinationSum4(int[] nums, int target) {    
        return totalWaysSumUptoTarget(nums,target);
    }
}