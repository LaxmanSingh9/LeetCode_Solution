class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0],profit=0,n=prices.length;
        for(int i=1;i<n;i+=1){
            if(prices[i]-min>profit){
                profit=prices[i]-min;
            }
            else{
                min=Math.min(min,prices[i]);
            }
        }
        return profit;
        
    }
}