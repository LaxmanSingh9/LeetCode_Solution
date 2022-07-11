class Solution {
    public int totalSumOfArr(int []neededTime){
        int total=0;
        for(int val:neededTime)total+=val;
        return total;
    }
    public int solve(String s,int[]neededTime,int prev ,int i,int[][]dp){
        if(i==neededTime.length)return 0;
        
        if(prev!=-1 && dp[i][prev]!=-1)return dp[i][prev];
        int val;
        if(prev!=-1 && prev==s.charAt(i)-'a'){
            val=solve(s,neededTime,prev,i+1,dp);
        }
        else{
            val=Math.max(solve(s,neededTime,prev,i+1,dp),
                         solve(s,neededTime,s.charAt(i)-'a',i+1,dp)+neededTime[i]);
        }
        if(prev!=-1)
          dp[i][prev]=val;
        return val;
    }
    public int minCost(String colors, int[] neededTime) {
        int[] []dp=new int[colors.length()][27];
        for(int []ar:dp)
          Arrays.fill(ar,-1);
        return totalSumOfArr(neededTime)-solve(colors,neededTime,-1,0,dp);
    }
}