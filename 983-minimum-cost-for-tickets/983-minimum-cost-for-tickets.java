class Solution {
   public boolean search(int tarv,int []ar){
      for(int v:ar){
         if(v==tarv)
            return true; 
      }
      return false; 
   } 
   public int mincostTickets(int[] days, int[] costs) {
        int []dayBuy=new int[]{1,7,30};
        int []dp=new int[367];
        for(int i=1;i<=365;i++){
          if(search(i,days)){
               int min=Integer.MAX_VALUE;
               for(int j=0;j<3;j++){
                   int day=Math.max(0,i-dayBuy[j]); 
                   min=Math.min(min,costs[j]+dp[day]);   
               }
               dp[i]=min;
           }
           else dp[i]=dp[i-1]; 
        } 
        return dp[365];
    }
}