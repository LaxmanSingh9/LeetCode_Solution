class Solution {
    public int getMinDistance(char []word1,char []word2){
        int [][]dp=new int[word1.length+2][word2.length+2];
        for(int i=0;i<word1.length+1;i++)
            dp[i][0]=i;
        for(int j=0;j<word2.length+1;j++)
            dp[0][j]=j;
        for(int i=1;i<word1.length+1;i++){
           for(int j=1;j<word2.length+1;j++){
               if(word1[i-1]==word2[j-1])
                   dp[i][j]=dp[i-1][j-1];
               else
                  dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])); 
           } 
        }
        return dp[word1.length][word2.length];
    }
    public int minDistance(String word1, String word2) {
        int [][]memo=new int[word1.length()+1][word2.length()+1];
        for(int []ar:memo)
          Arrays.fill(ar,-1);
        return getMinDistance(word1.toCharArray(),word2.toCharArray());
    }
}