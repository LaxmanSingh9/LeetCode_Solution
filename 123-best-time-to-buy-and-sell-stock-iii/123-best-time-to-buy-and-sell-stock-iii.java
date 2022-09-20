class Solution {
    public int solve(int []prices,int type, int trans,int idx,int[][][]memo){
       if(idx>=prices.length || trans<= -1)
          return 0; 
       if(memo[type][trans][idx]!=-1)
          return memo[type][trans][idx]; 
       int ans1=0,ans2=0;
       if(type==1)
           ans1=Math.max(-prices[idx]+solve(prices,0,trans,idx+1,memo),solve(prices,1,trans,idx+1,memo));
       else
           ans2=Math.max(prices[idx]+solve(prices,1,trans-1,idx+1,memo),solve(prices,0,trans,idx+1,memo));
       return memo[type][trans][idx]=Math.max(ans1,ans2); 
        
    }
    public int maxProfit(int[] prices) {
        int trans=2;
        int [][][]memo=new int[2][trans][prices.length+1];
        for(int [][]arr:memo){
           for(int []ar:arr)
              Arrays.fill(ar,-1); 
        }
        return solve(prices,1,1,0,memo);
    }
}