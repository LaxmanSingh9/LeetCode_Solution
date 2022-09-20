class Solution {
    public int solve(int []prices,int type,int idx,int [][]memo){
       if(idx>=prices.length)
          return 0; 
       if(memo[type][idx]!=-1)
          return memo[type][idx]; 
       int ans1=0,ans2=0,ans3=0; 
       if(type==1)
         ans1=Math.max(-prices[idx]+solve(prices,0,idx+1,memo),solve(prices,1,idx+1,memo));  
       else if(type== 0)
         ans2=Math.max(prices[idx]+solve(prices,2,idx+1,memo),solve(prices,0,idx+1,memo));
       else
         ans3=solve(prices,1,idx+1,memo);
       return memo[type][idx]=Math.max(ans1,Math.max(ans2,ans3)); 
    }
    public int maxProfit(int[] prices){
       int [][]memo=new int[3][prices.length+1]; 
       for(int []ar:memo)
          Arrays.fill(ar,-1); 
       return solve(prices,1,0,memo); 
    }
}