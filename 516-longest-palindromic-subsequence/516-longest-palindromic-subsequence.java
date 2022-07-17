class Solution {
    public int longestPalindromeSubseq(String s) {
      int n=s.length();int dp[][]=new int[s.length()+2][s.length()+2];
     
      for(int i=n-1;i>=0;i-=1){
         for(int j=n-1;j>=0;j-=1){
             if(s.charAt(i)==s.charAt(n-1-j)){
                 dp[i][j]=1+dp[i+1][j+1];
             }
             else{
                 dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
             }
         }
      }
      return dp[0][0];      
  }
}