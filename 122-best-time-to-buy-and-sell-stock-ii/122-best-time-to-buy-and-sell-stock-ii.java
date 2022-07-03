class Solution {
    public int maxProfit(int[] prices) {
        int buy=0,sell=0,profit=0,i=1,n=prices.length;
        while(i<n){
           while(i<n && prices[i-1]>=prices[i])
             i+=1;
           buy=prices[i-1];
           while(i<n && prices[i-1]<prices[i])
              i+=1;
           sell=prices[i-1];profit+=sell-buy;
        }
        return profit;
    }
}