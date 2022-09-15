class Solution {
    public boolean isPalm(String s, int l,int r){
        while(l<r){
            if(s.charAt(l++)!=s.charAt(r--))
                return false;
        }
        return true;
    }
    public void solve(String s,int st,int e,boolean[][] dp){
          if(st==e){
              dp[st][e]=true;
              return ;
          }
          for(int i=st;i<=e;i++){
             if(!dp[st][i] && isPalm(s,st,i)){
                 dp[st][i]=true;
                 solve(s,i+1,e,dp);
             }
          } 
    }
    public int countSubstrings(String s) {
       boolean [][]dp=new boolean[s.length()+1][s.length()+1];
       int ans=0,n=s.length();
       solve(s,0,s.length()-1,dp);
       for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
              if(dp[i][j])ans++;
          } 
       }
       return ans; 
    }
}