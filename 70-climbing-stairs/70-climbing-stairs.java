class Solution {
    public int solve(int n,int[]memo){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(memo[n]!=-1){
            return memo[n];
        }
        int smallAns=solve(n-1,memo)+solve(n-2,memo);
        memo[n]=smallAns;
        return smallAns;
    }
    public int climbStairs(int n) {
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return solve(n,memo);
        
    }
}