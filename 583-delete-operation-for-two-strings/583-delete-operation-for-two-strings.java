class Solution {
    public int LCS(String word1,String word2 ,int i ,int j,int [][]memo){
        if(i==word1.length() || j==word2.length())return 0;
        if(memo[i][j]!=-1)return memo[i][j];
        int val=0;
        if(word1.charAt(i)==word2.charAt(j)){
            val=LCS(word1,word2,i+1,j+1,memo)+1;
        }
        else{
            val=Math.max(LCS(word1,word2,i+1,j,memo),
                         LCS(word1,word2,i,j+1,memo));
        }
        memo[i][j]=val;
        return val;
    }
    public int minDistance(String word1, String word2) {
        int [][]memo=new int[word1.length()][word2.length()];
        int totalLength=word1.length()+word2.length();
        for(int []ar:memo)Arrays.fill(ar,-1);
        return totalLength-2*LCS(word1,word2,0,0,memo);
    }
}