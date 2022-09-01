class Solution {
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length,ans=1;
        Arrays.sort(pairs,(a,b)->{
            if(a[0]>b[0])
               return 1;
            if(a[0]<b[0])
               return -1;
            if(a[1]>b[1])
               return 1;
            if(a[1]<b[1]);
            return 0;
        });
        int []dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
           for(int j=n-1;j>=0;j--){
              if(pairs[i][0]>pairs[j][1])
                  dp[i]=Math.max(dp[i],dp[j]+1);
           } 
           ans=Math.max(ans,dp[i]); 
        }
        return ans;
    }
}