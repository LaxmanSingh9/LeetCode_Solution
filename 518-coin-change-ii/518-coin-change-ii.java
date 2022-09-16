class Solution {
    public int waysToUptoAmt(int []coins,int amt,int idx,int [][]memo){
        if(amt==0)
            return 1;
        if(idx<0)return 0;
        if(memo[idx][amt]!=-1)
            return memo[idx][amt];
        int ans1=0,ans2=0;
        if(coins[idx]<=amt){
            ans1=Math.max(waysToUptoAmt(coins,amt-coins[idx],idx-1,memo),
                          waysToUptoAmt(coins,amt-coins[idx],idx,memo));
        }
        ans2=waysToUptoAmt(coins,amt,idx-1,memo);
        return memo[idx][amt]=ans1+ans2;
    }
    public int change(int amount, int[] coins) {
        int [][]memo=new int[coins.length+1][amount+1];
        for(int []ar:memo)
            Arrays.fill(ar,-1);
        return waysToUptoAmt(coins,amount,coins.length-1,memo);
    }
}