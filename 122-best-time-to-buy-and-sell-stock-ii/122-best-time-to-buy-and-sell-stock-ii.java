class Solution {
    public int maxProfit(int[] prices) {
        int prevBuy=-prices[0],prevSell=0;
        
        for(int i=1;i<prices.length;i+=1){
           prevBuy=Math.max(prevBuy,prevSell-prices[i]);
           prevSell=Math.max(prevSell,prevBuy+prices[i]);
            
        }
        return prevSell;
        
    }
}