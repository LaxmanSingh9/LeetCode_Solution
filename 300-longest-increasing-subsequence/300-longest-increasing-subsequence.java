class Solution {
  
    public int lengthOfLIS(int[] nums) {
        int n=nums.length,ans=1;
        int[]dp=new int[n];Arrays.fill(dp,1);
        for(int i=1;i<n;i+=1){
         for(int j=i-1;j>=0;j-=1){
            if(nums[i]>nums[j]){
                dp[i]=Math.max(dp[i],dp[j]+1);
            }   
          }
          ans=Math.max(dp[i],ans);
        }
        return ans;
        
        
    }
}