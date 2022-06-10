class Solution {
 
    public int solve(String s,String t,int i,int j,int[][]memo){
       if(i==-1 || j==-1){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int val;
        if(s.charAt(i)==t.charAt(j)){
            val=1+solve(s,t,i-1,j-1,memo);
        
        }
        else{
            int ans1=solve(s,t,i-1,j,memo);
            int ans2=solve(s,t,i,j-1,memo);
            val=Math.max(ans1,ans2);
        }
        memo[i][j]=val;
        return val;
        
    }
    
    public boolean isSubsequence(String s, String t) {
        int n=s.length();int m=t.length();
        if(m==0 && n==0){
            return true;
        }
        if(m==0 ||n==0){
            return m==0?false:true;
        }
        int [][]memo=new int[n][m];
        for(int ar[]:memo){
            Arrays.fill(ar,-1);
        }
        int val=solve(s,t,0,0,memo);
        return solve(s,t,n-1,m-1,memo)==n;
        
    }
    
    
}