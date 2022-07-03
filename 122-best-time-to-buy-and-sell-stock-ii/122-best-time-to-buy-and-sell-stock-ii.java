class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length, buy[]=new int[n],sell[]=new int[n];
        int prevBuy=-prices[0],prevSell=0;
        
        for(int i=1;i<n;i+=1){
           prevBuy=Math.max(prevBuy,prevSell-prices[i]);
           prevSell=Math.max(prevSell,prevBuy+prices[i]);
            
        }
        return prevSell;
        
    }
}