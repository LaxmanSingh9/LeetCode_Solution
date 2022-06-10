class Solution {
    
    public int solve(int[]prices,int buy,int trans,int[][]memo,int index){
        if(index>=prices.length || trans<=0){
            return 0;
        }
        if(memo[index][buy]!=-1){
            return memo[index][buy];
        }
        if(buy==1){
            int ans1=-prices[index]+solve(prices,buy^1,trans,memo,index+1);
            int ans2=solve(prices,buy,trans,memo,index+1);
            memo[index][buy]=Math.max(ans1,ans2);
            return memo[index][buy];
        }
        else{
            int ans1=prices[index]+solve(prices,buy^1,trans-1,memo,index+1);
            int ans2=solve(prices,buy,trans,memo,index+1);
            memo[index][buy]=Math.max(ans1,ans2);
            return memo[index][buy];
            
        }
       
      

        
    }
    
    
    
    
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][]memo=new int[n][2];
        for(int[] ar:memo){
            Arrays.fill(ar,-1);
        }
        return solve(prices,1,1,memo,0);
        
    } 
}