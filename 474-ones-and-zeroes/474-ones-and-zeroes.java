class Solution {
    public int cal(String s){
        Map<String,Integer>map=new HashMap<>();
        int totalZeros=0;
        for(char c:s.toCharArray()){
            if(c=='0')
              map.put("0",map.getOrDefault("0",0)+1);
        }
        totalZeros=map.getOrDefault("0",0);
        return totalZeros;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int [][][]dp=new int[strs.length+1][m+1][n+1];
        int ans=0,zeros=0,ones=0;
        for(int i=0;i<strs.length+1;i+=1){
            if(i!=0){
                 zeros=cal(strs[i-1]);ones=(strs[i-1].length())-zeros;
            }
            for(int j=0;j<m+1;j+=1){
              for(int k=0;k<n+1;k+=1){
                  if(i==0)
                     dp[i][j][k]=0;
                  else if(j>=zeros && k>=ones)
                     dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zeros][k-ones]+1);
                 
                 else
                    dp[i][j][k]=dp[i-1][j][k];
                }
            }
        }
        return dp[strs.length][m][n];
    }
}