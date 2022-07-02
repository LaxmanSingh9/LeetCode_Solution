class Solution {
    public int solve(int []prices,int buy,int i,int fee,int[][]memo){
         if(i==prices.length || memo[i][buy]!=-1){
             return i==prices.length?0:memo[i][buy];
         }
         int a=0,b=0;
         if(buy==1){
             a=solve(prices,buy^1,i+1,fee,memo)-prices[i];
             b=solve(prices,buy,i+1,fee,memo);
         }
         else{
             a=solve(prices,buy^1,i+1,fee,memo)+prices[i]-fee;
             b=solve(prices,buy,i+1,fee,memo);
            
         }
         memo[i][buy]=Math.max(a,b);
         return memo[i][buy];
    }
    public int maxProfit(int[] prices, int fee) {
        int[][]memo=new int[prices.length+1][2];
        for(int []ar:memo){
            Arrays.fill(ar,-1);
        }
        return solve(prices,1,0,fee,memo);
        
    }
}