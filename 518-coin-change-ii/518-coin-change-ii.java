class Solution {
    public int waysToUptoAmt(int []coins,int amt){
       int [][]dp=new int[coins.length+1][amt+1];
       dp[0][0]=1; 
       for(int i=1;i<coins.length+1;i++){
          dp[i][0]=1;  
          for(int j=1;j<amt+1;j++){
               dp[i][j]=dp[i-1][j];
               if(j>=coins[i-1])
                dp[i][j]=dp[i][j]+dp[i][j-coins[i-1]];   
          } 
       } 
       return dp[coins.length][amt]; 
        
    }
    public int change(int amount, int[] coins) {
        return waysToUptoAmt(coins,amount);
    }
}