class Solution {
  public int totalPerSqUpToN(int target){
        int []dp=new int[target+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<target+1;i++){
          for(int j=1;j*j<=i;j++){
              int sq=j*j;
              dp[i]=Math.min(dp[i],1+dp[i-sq]);
           } 
        }
        return dp[target];
    }
    public int numSquares(int n) {
        return totalPerSqUpToN(n);
    }
}