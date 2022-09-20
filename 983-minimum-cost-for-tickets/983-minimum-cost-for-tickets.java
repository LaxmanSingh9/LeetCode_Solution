class Solution {
    int []dayBuy=new int[]{1,7,30};
    public int solve(int []days,int[] costs,int i,int day,int [][]memo){
        if(i>=days.length)
            return 0;
        if(memo[i][day]!=-1)
            return memo[i][day];
        if(day>=days[i]){
            int m=solve(days,costs,i+1,day,memo);
            return memo[i][day]=m;
        }    
        int min=Integer.MAX_VALUE;
        for(int j=0;j<3;j++)
            min=Math.min(min,costs[j]+solve(days,costs,i+1,days[i]+dayBuy[j]-1,memo));
        return memo[i][day]=min;
    }
    public int mincostTickets(int[] days, int[] costs) {
         int [][]memo=new int[days.length+1][400];
         for(int []ar:memo)
             Arrays.fill(ar,-1);
         return solve(days,costs,0,0,memo);  
    }
}