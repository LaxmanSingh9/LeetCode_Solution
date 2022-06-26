import java.util.*;
class Solution {
     public int solve(int l,int r,char[] s,int [][]memo){
        if(r<l){// if lenght is 1
            return 1;
        }
        if(memo[l][r]!=-1){
            return memo[l][r];
        }
        memo[l][r]=s[l]!=s[r]?0:solve(l+1,r-1,s,memo);
        solve(l+1,r,s,memo);
        solve(l,r-1,s,memo);
        return memo[l][r];
        
    }
    
    
    public int countSubstrings(String s) {
      int n=s.length();
        int [][]memo=new int[n+2][n+2];
        for(int []row:memo){
            Arrays.fill(row,-1);
        }
        int ans=0;
        solve(0,n-1,s.toCharArray(),memo);
        for(int i=0;i<n;i+=1){
           for(int j=i;j<n;j+=1){
               if(memo[i][j]==1){
                   ans+=1;
               }
           } 
            
        }
        System.out.println(memo[1][1]);
        return ans;
    }
}