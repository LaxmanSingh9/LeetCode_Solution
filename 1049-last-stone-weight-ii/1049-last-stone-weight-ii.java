class Solution {
   
    public int lastStoneWeightII(int[] arr) {
        int sum=0,n=arr.length;
        for(int val:arr)sum+=val;
        boolean [][]dp=new boolean[arr.length+1][sum/2+1];
        int target=(sum>>1),ans=Integer.MAX_VALUE;
        dp[0][0]=true;
        for(int i=1;i<n+1;i+=1)dp[i][0]=true;
        for(int j=1;j<target+1;j+=1)dp[0][j]=false;
        for(int i=1;i<n+1;i+=1){
          for(int j=1;j<target+1;j+=1){
              if(arr[i-1]<=j)dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
              else dp[i][j]=dp[i-1][j];
          }
        }
       for(int j=0;j<target+1;j+=1)
           if(dp[n][j])ans=Math.min(ans,sum-2*j);
        return ans;
    }
}