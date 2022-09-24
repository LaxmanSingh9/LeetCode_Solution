class Solution {
    public int countGoodSubstrings(String s) {
       int ans=0;int []dp=new int[26];
       if(s.length()<3)return 0; 
       dp[s.charAt(0)-97]+=1;dp[s.charAt(1)-97]+=1; 
       for(int i=2;i<s.length();i++){
          dp[s.charAt(i)-97]+=1; 
          if(dp[s.charAt(i)-97]==1 && dp[s.charAt(i-1)-97]==1 && dp[s.charAt(i-2)-97]==1)
              ans+=1;
          dp[s.charAt(i-2)-97]-=1;; 
       }
       return ans; 
        
    }
}