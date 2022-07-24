class Solution {
    public int countHousePlacements(int n) {
        if(n==1 ){
            return 4;
        }
        if(n==2){
            return 9;
        }
        long mod=1000000007L;
        long []dp=new long[n+1];
        dp[0]=1L;dp[1]=2L;dp[2]=3L;
        for(int i=3;i<=n;i+=1){
            dp[i]=(dp[i-1]+dp[i-2])%mod;
            
        }
        return  (int) ((dp[n]*dp[n])%mod) ;
    }
}