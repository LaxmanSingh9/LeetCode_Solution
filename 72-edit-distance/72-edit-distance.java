class Solution {
    public int getMinDistance(String word1,String word2,int i,int j,int [][]memo){
         if(i>=word1.length())
             return word2.length()-j;
         if(j>=word2.length())
             return word1.length()-i;
         if(memo[i][j]!=-1)
            return memo[i][j]; 
         if(word1.charAt(i)==word2.charAt(j)){
            memo[i][j]=getMinDistance(word1,word2,i+1,j+1,memo);
         }
         else{
            int opReplace=getMinDistance(word1,word2,i+1,j+1,memo);
            int opDel=getMinDistance(word1,word2,i+1,j,memo);
            int opInsert=getMinDistance(word1,word2,i,j+1,memo);
            memo[i][j]=1+Math.min(opReplace,Math.min(opDel,opInsert));
         }
         return memo[i][j];
    }
    public int minDistance(String word1, String word2) {
        int [][]memo=new int[word1.length()+1][word2.length()+1];
        for(int []ar:memo)
          Arrays.fill(ar,-1);
        return getMinDistance(word1,word2,0,0,memo);
    }
}