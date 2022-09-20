class Solution {
    public int solve(int []prices,int idx,int type,int[][]memo){
        if(idx>=prices.length)
            return 0;
        if(memo[type][idx]!=-1)
           return memo[type][idx]; 
        int ans1=0,ans2=0;
        if(type==1)
          ans1=Math.max(-prices[idx]+solve(prices,idx+1,0,memo),solve(prices,idx+1,1,memo));  
        else
          ans2=Math.max(prices[idx]+solve(prices,idx+1,1,memo),solve(prices,idx+1,0,memo));
        return memo[type][idx]=Math.max(ans1,ans2);
    }
    public int maxProfit(int[] prices) {
       int [][]memo=new int[2][prices.length]; 
       for(int []ar:memo)
          Arrays.fill(ar,-1); 
       return solve(prices,0,1,memo); 
    }
     //There are three options on each day either buy on it or sell on it
       //if buy then sell 
       //if sell them buy
       //skip it
}