class Solution {
  public int lengthOfLIS(int[] nums) {
        int []dp=new int[nums.length+1];
        Arrays.fill(dp,1);int ans=1;
        for(int i=1;i<nums.length;i+=1){
          for(int j=i;j>=0;j-=1){
              if(nums[i]>nums[j])
                dp[i]=Math.max(dp[i],dp[j]+1);//include and exclude
          }
          ans=Math.max(dp[i],ans);
        }
        return ans;
    }
}