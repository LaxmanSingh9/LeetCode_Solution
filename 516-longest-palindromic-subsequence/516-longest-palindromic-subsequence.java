class Solution {
    public String reverseString(String  s){
        String revStr="";int n=s.length();
        for(int i=0;i<n;i+=1){
            revStr=s.charAt(i)+revStr;
        }
        return revStr;
    }
    public int LCS(String s1,String s2, int i ,int j ,int[][] memo){
        if(i==s1.length() || j==s1.length()){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=LCS(s1,s2,i+1,j+1,memo)+1;
        }
        else{
            memo[i][j]= Math.max(LCS(s1,s2,i+1,j,memo),LCS(s1,s2,i,j+1,memo));
        }
        return  memo[i][j];
        
    }
   public int longestPalindromeSubseq(String s) {
      int [][]memo=new int[s.length()+1][s.length()+1];
      for(int []ar:memo)Arrays.fill(ar,-1);
      return LCS(s,reverseString(s),0,0,memo);      
  }
}