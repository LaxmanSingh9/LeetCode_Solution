class Solution {
    public int minCoinUptoAmt(int []coins,int amt){
        int [][]dp=new int[coins.length+1][amt+1];
        int maxLimit=100000;
        for(int i=1;i<amt+1;i++)
            dp[0][i]=maxLimit;
        for(int i=0;i<coins.length+1;i++)
            dp[i][0]=0;
        for(int i=1;i<coins.length+1;i++){
           for(int j=1;j<amt+1;j++){
               dp[i][j]=dp[i-1][j];
               if(j>=coins[i-1]){
                   dp[i][j]=Math.min(dp[i][j],1+
                                     Math.min(dp[i][j-coins[i-1]],dp[i-1][j-coins[i-1]])) ;
               }
           } 
        }
        return dp[coins.length][amt]>=maxLimit?-1:dp[coins.length][amt];
     }
    
    public int coinChange(int[] coins, int amount) {
       // Arrays.sort(coins);
        return minCoinUptoAmt(coins,amount);
       //Sort the coins in incresng order
      //Recur reletions
        //coin>Amount skip
        //select the coin // stil consideration
        
        
    }
}