class Solution {
    public int lcs(char[] text1 ,char[] text2){
        int [][]dp=new int[text1.length+1][text2.length+1];
        for(int i=1;i<text1.length+1;i++){
           for(int j=1;j<text2.length+1;j++){
               if(text1[i-1]==text2[j-1])
                   dp[i][j]=1+dp[i-1][j-1];
               else
                  dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]); 
           } 
        }
        return dp[text1.length][text2.length];
    }
    public int longestCommonSubsequence(String text1, String text2) {
       return lcs(text1.toCharArray(),text2.toCharArray()); 
        
        
      //will compare both the strings recursively if s[i]==s[j]=>(i+1,j+1)
      //s[i]!=s[j]=Max(i+1,j),(i,j+1)
        
    }
}