class Solution {
    public int totalAsciiSum(String s){
        int asciiSum=0;
        for(char c:s.toCharArray()){
            asciiSum+=c;
        }
        return asciiSum;
    }
    public int getMaxAsciiSumOfLCS(String s1,String s2,int i,int j,int[][]memo){
        if(i>=s1.length() || j>=s2.length() || memo[i][j]!=-1)
            return memo[i][j]==-1?0:memo[i][j];
        int incl=0,skip=0;
        if(s1.charAt(i)==s2.charAt(j)){
            incl=s1.charAt(i)+getMaxAsciiSumOfLCS(s1,s2,i+1,j+1,memo);
            memo[i][j]=incl;
        }
        else{
            memo[i][j]=Math.max(getMaxAsciiSumOfLCS(s1,s2,i+1,j,memo),
                      getMaxAsciiSumOfLCS(s1,s2,i,j+1,memo));
        }  
        return memo[i][j];
    }
    public int minimumDeleteSum(String s1, String s2) {
        int [][]memo=new int[s1.length()+1][s2.length()+1];
        for(int []ar:memo)
            Arrays.fill(ar,-1);
        return totalAsciiSum(s1)+totalAsciiSum(s2)-2*getMaxAsciiSumOfLCS(s1,s2,0,0,memo);
    }
}