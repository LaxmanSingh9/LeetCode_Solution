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
        int [][]dp=new int[m+1][n+1];
        int ans=0,zeros=0,ones=0;
        for(int i=strs.length-1;i>=0;i-=1){
            zeros=cal(strs[i]);ones=(strs[i].length())-zeros;
            for(int j=m;j>=zeros;j-=1){
              for(int k=n;k>=ones;k-=1){
                  dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones]+1);
              }
                
            }
        }
        return dp[m][n];
    }
}