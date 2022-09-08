class Solution {
    public int lcs(String s ,String t){
       int lenS=s.length(),lenT=t.length();
       int [][]dp=new int[lenS+1][lenT+1];
       dp[0][0]=1;
       for(int i=1;i<lenS+1;i++){
          dp[i][0]=1; 
          for(int j=1;j<lenT+1;j++){
             if(s.charAt(i-1)==t.charAt(j-1)){
                 dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
             } 
             else{
                dp[i][j]=dp[i-1][j]; 
             } 
          } 
       }
       return dp[lenS][lenT]; 
    }
    public int numDistinct(String s, String t) {
        return lcs(s,t);
    }
}