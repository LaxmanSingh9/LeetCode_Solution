class Solution {
    public String shortestCommonSupersequence(int [][]dp,String s1, String s2) {
        int i = 0, j = 0,l = 0;
        char []ans=new char[s1.length()+s2.length()-dp[0][0]];
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                ans[l++]=s1.charAt(i);
                i+=1;j+=1;
                
            }
            else if(dp[i+1][j]<dp[i][j+1]){
                ans[l++]=s2.charAt(j);
                j+=1;
            }
            else{
                ans[l++]=s1.charAt(i);
                i+=1;
            }
            
            
        }
        while(i<s1.length()){
            ans[l++]=s1.charAt(i);i+=1;
        }
        while(j<s2.length()){
            ans[l++]=s2.charAt(j);j+=1;
        }
        return new String(ans);
    }
    public int[][] LCS(String s1,String s2,int[][]dp){
       for(int i=s1.length()-1;i>=0;i-=1){
           for(int j=s2.length()-1;j>=0;j-=1){
               if(s1.charAt(i)==s2.charAt(j)){
                   dp[i][j]=dp[i+1][j+1]+1;
               }
               else{
                   dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
               }
           }
       }
       return dp;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
         int [][]dp=new int[str1.length()+1][str2.length()+1];
         return shortestCommonSupersequence(LCS(str1,str2,dp),str1,str2);
         
        
    }
}