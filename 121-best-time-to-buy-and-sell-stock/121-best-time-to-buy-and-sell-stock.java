class Solution {
    
//     public int solve(int[]prices,int type,int index){
//         if(index<=-1){
//             return 0;
//         }
//        int ans1=solve(prices,1,index+1)+prices[index];
//        int ans2=solve(prices,0,index+1)-prices[index]
      
        
        
//     }
    
    public int maxProfit(int[] prices) {
        int sell=Integer.MAX_VALUE;
        int profit=0;
        for(int i=0;i<prices.length;i+=1){
            if(sell<prices[i]){
                profit=Math.max(profit,prices[i]-sell);
            }
            else{
                sell=prices[i];
            }
        }
        return profit;
    }
}