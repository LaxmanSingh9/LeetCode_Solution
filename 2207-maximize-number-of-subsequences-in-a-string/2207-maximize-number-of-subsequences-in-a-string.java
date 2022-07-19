class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int totalZeroIndexChar=0,totalOneIndexChar=0,n=text.length();
        int []dp=new int[n];long ans=0;
        for(int i=n-1;i>=0;i-=1){
            if(text.charAt(i)==pattern.charAt(1)){
                dp[i]=i!=n-1?dp[i+1]+1:1;
            }
            else{
                dp[i]=i!=n-1?dp[i+1]:0;
            }
        }
        for(int i=0;i<text.length();i+=1){
            if(text.charAt(i)==pattern.charAt(0)){
                totalZeroIndexChar+=1;
                ans+=dp[i];
            }
        }
        if(pattern.charAt(0)!=pattern.charAt(1)){
             ans+=Math.max(dp[0],totalZeroIndexChar);
        }
       
        return ans;
        
    }
}