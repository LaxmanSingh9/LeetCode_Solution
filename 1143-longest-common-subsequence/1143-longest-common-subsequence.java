class Solution {
    public int lcs(String text1 ,String text2,int i,int j,int [][]memo){
        if(i>=text1.length() || j>=text2.length())
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
             memo[i][j]=1+lcs(text1,text2,i+1,j+1,memo);
        }
        else{
            memo[i][j]=Math.max(lcs(text1,text2,i+1,j,memo),
                                lcs(text1,text2,i,j+1,memo));
        }
        return memo[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {
       int [][]memo=new int[text1.length()+1][text2.length()+1];
       for(int []ar:memo)
           Arrays.fill(ar,-1);
       return lcs(text1,text2,0,0,memo); 
        
        
      //will compare both the strings recursively if s[i]==s[j]=>(i+1,j+1)
      //s[i]!=s[j]=Max(i+1,j),(i,j+1)
        
    }
}