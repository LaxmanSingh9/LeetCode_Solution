class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int totalZeroIndexChar=0,n=text.length();
        int []dp=new int[n];long ans=0;
        dp[0]=text.charAt(0)==pattern.charAt(1)?1:0;
        for(int i=1;i<n;i+=1){
            if(text.charAt(i)==pattern.charAt(1)){
                dp[i]=dp[i-1]+1;
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        for(int i=0;i<text.length();i+=1){
            if(text.charAt(i)==pattern.charAt(0)){
                totalZeroIndexChar+=1;
                ans+=(dp[n-1]-dp[i]);
            }
        }
        ans+=Math.max(dp[n-1],totalZeroIndexChar);
        return ans;
        
    }
}