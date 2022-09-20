class Solution {
    public int solve(int []prices,int idx,int type,int fee,int[][]memo){
        if(idx>=prices.length)
            return 0;
        if(memo[type][idx]!=-1)
           return memo[type][idx]; 
        int prfit1=0,prfit2=0;
        if(type==1)
          prfit1=Math.max(-prices[idx]+solve(prices,idx+1,0,fee,memo),solve(prices,idx+1,1,fee,memo));  
        else
          prfit2=Math.max(prices[idx]-fee+solve(prices,idx+1,1,fee,memo),solve(prices,idx+1,0,fee,memo));
        return memo[type][idx]=Math.max(prfit1,prfit2);
    }
    public int maxProfit(int[] prices, int fee) {
       int [][]memo=new int[3][prices.length+1]; 
       for(int []ar:memo)
          Arrays.fill(ar,-1); 
       return solve(prices,0,1,fee,memo); 
    }
}