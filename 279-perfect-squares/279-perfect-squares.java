class Solution {
    public int[] perSqUpToN(int n){
       int []ar=new int[n];
       ar[0]=1;
       for(int i=2;i<=n;i++)
          ar[i-1]=i*i; 
       return ar;
    }
    public int totalPerSqUpToN(int target,int []ar){
        int [][]dp=new int[ar.length+1][target+1];
        for(int i=1;i<target+1;i++)
           dp[0][i]=Integer.MAX_VALUE;
        for(int i=1;i<ar.length+1;i++){
          for(int j=1;j<target+1;j++){
              dp[i][j]=dp[i-1][j];
              if(j>=ar[i-1])
                  dp[i][j]=Math.min(dp[i][j],1+dp[i][j-ar[i-1]]);
           } 
        }
        return dp[ar.length][target];
    }
    public int numSquares(int n) {
        return totalPerSqUpToN(n,perSqUpToN(100));
    }
}