class Solution {
    public String shortestCommonSupersequence(String lcs,String s1, String s2) {
        int i = 0, j = 0;
        String ans = "";
        for (char c : lcs.toCharArray()) {
            while(s1.charAt(i) != c){ ans += s1.charAt(i);i+=1;}
            while (s2.charAt(j) != c){ans += s2.charAt(j);j+=1;}
            ans += c;i+=1;j+=1;
        }
        return ans + s1.substring(i) + s2.substring(j);
    }
    public String LCS(String s1,String s2,String[][]dp){
       for(int i=s1.length()-1;i>=0;i-=1){
           for(int j=s2.length()-1;j>=0;j-=1){
               if(s1.charAt(i)==s2.charAt(j)){
                   dp[i][j]=s1.charAt(i)+dp[i+1][j+1];
               }
               else{
                   dp[i][j]=dp[i+1][j].length()>dp[i][j+1].length()?dp[i+1][j]:dp[i][j+1];
               }
           }
       }
       return dp[0][0];
    }
    public String shortestCommonSupersequence(String str1, String str2) {
         String [][]dp=new String[str1.length()+1][str2.length()+1];
         for(String []ar:dp)Arrays.fill(ar,"");
         return shortestCommonSupersequence(LCS(str1,str2,dp),str1,str2);
         
        
    }
}