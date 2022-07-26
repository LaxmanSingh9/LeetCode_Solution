class Solution {
    public int calSumOfArr(int []ar){
        int ans=0;
        for(int val:ar)
            ans+=val;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int sumOfArr=calSumOfArr(nums);
        if((sumOfArr&1)==1)
          return false;
        int n=nums.length,target=sumOfArr/2;
        boolean []dp=new boolean[target+1];
        dp[0]=true;
        for(int num:nums){
            for(int i=target;i>=num;i-=1){
                dp[i]=(dp[i]||dp[i-num]);
            }
        }
        return dp[target];
    }
}














