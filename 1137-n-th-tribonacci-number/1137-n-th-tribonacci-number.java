class Solution {
    public int solve(int n,int []ans){
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        if(ans[n]!=-1){
            return ans[n];
        }
        ans[n]=solve(n-1,ans)+solve(n-2,ans)+solve(n-3,ans);
        return ans[n];
    }
    public int tribonacci(int n) {
        int ans[]=new int[n+1];
        Arrays.fill(ans,-1);
        return solve(n,ans);
    }
}