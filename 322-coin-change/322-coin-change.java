class Solution {
    public int minCoinUptoAmt(int []coins,int amt ,int idx,int [][]memo){
        if(amt==0){
            return 0;
        }
        if(idx<0)
            return 100000;
        if(memo[idx][amt]!=-1)
            return memo[idx][amt];
        int ans1=100000,ans2=100000;
        if(coins[idx]<=amt){
            ans1=1+Math.min(minCoinUptoAmt(coins,amt-coins[idx],idx-1,memo),
                            minCoinUptoAmt(coins,amt-coins[idx],idx,memo));
        } 
        ans2=minCoinUptoAmt(coins,amt,idx-1,memo);
        return memo[idx][amt]=Math.min(ans1,ans2);
     }
    
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int [][]memo=new int[coins.length+1][amount+1];
        for(int []ar:memo)
            Arrays.fill(ar,-1);
        int minCoins=minCoinUptoAmt(coins,amount,coins.length-1,memo),maxLimit=100000;
        return minCoins>=maxLimit?-1:minCoins;
       //Sort the coins in incresng order
      //Recur reletions
        //coin>Amount skip
        //select the coin // stil consideration
        
        
    }
}