class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0,n=s.length();
        int dp[][]=new int[n+1][n+1];
        
        for(int j=0;j<n;j+=1){
          for(int i=0;i<n-j;i+=1){
              int left=i,right=i+j;
              if(left+1>=right-1 && s.charAt(left)==s.charAt(right)){
                  dp[left][right]=1;start=i; end=j+1;
              }
              else if(s.charAt(left)==s.charAt(right) && dp[left+1][right-1]==1){
                 dp[left][right]=1;start=i; end=j+1; 
              }
              
          }
        }
        return s.substring(start, end+start);
        
    }
}