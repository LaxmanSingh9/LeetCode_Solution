class Solution {
   public int maxProfit(int[] prices) {
       int [][]dp=new int[2][prices.length+1];
       dp[0][0]=Integer.MIN_VALUE;
       for(int i=1;i<prices.length+1;i++){
          dp[0][i]=Math.max(dp[0][i-1], -prices[i-1]+dp[1][i-1]);//buy
          dp[1][i]=Math.max(dp[1][i-1], prices[i-1]+dp[0][i-1]);//sell
      }
      return Math.max(dp[0][prices.length],dp[1][prices.length]); 
     
    }
     //There are two options on each day either buy on it or sell on it
       //if buy then sell 
       //if sell them buy
       //skip it
}