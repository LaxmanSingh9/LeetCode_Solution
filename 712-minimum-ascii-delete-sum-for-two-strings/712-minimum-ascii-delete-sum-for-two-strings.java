class Solution {
     public int asciiOfAnString(String s){
        int asciiSum=0;
        for(int i=0;i<s.length();i+=1)
             asciiSum+=(int)s.charAt(i);
        return asciiSum;
    }
    public int minimumDeleteSum(String s1, String s2) {
        int r=s1.length(),c=s2.length();
        int[][]dp=new int[r+1][c+1];
        for(int i=r-1;i>=0;i-=1){
            for(int j=c-1;j>=0;j-=1){
                if(s1.charAt(i)==s2.charAt(j)) dp[i][j]=dp[i+1][j+1]+(int)s1.charAt(i);
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return asciiOfAnString(s1)+asciiOfAnString(s2)-2*dp[0][0];
    }
    
}