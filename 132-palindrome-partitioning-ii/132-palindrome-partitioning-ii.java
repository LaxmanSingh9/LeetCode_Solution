class Solution {
    public int solve(String s,int st,int e,boolean [][]dp,int [][]memo){
        if(e-st==1 || dp[st][e-1])
            return 0;
        if(memo[st][e]!=-1)
            return memo[st][e];
        int minCut=s.length()-1;
        for(int i=st;i<e;i++){
            if(dp[st][i]){
                minCut=Math.min(minCut,1+solve(s,i+1,e,dp,memo));
            }
        }
        return memo[st][e]=minCut;
    }
    public int minCut(String s){
         boolean dp[][]=new boolean[s.length()+1][s.length()+1];
         for(int i=0;i<s.length();i++){//end
           for(int j=0;j<=i;j++){//start
               if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])) {
                   dp[j][i]=true;
               }
           } 
         }
         int [][]memo=new int[s.length()+1][s.length()+1];
         for(int []ar:memo){
             Arrays.fill(ar,-1);
         }
         return solve(s,0,s.length(),dp,memo);
        
       
     }
      
    
}