class Solution {
    public int solve(int places,int letterNum,int[][]dp){
        if(places==0){
            return 1;//String is formed
        }
        if(letterNum<=0){
            return 0; //Letter are finished
        }
        if(dp[places][letterNum]!=-1){
            return dp[places][letterNum];
        }
        dp[places][letterNum]=solve(places-1,letterNum,dp)+solve(places,letterNum-1,dp);
        return dp[places][letterNum];
        
    }
    
        
    public int countVowelStrings(int n) {
        int[][]dp=new int[n+1][6];
        for(int []ar:dp){
            Arrays.fill(ar,-1);
        }
        return solve(n,5,dp);
    }
}