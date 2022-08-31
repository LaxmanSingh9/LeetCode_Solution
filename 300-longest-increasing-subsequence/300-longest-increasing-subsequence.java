class Solution {
   public int lengthOfLIS(int[] arr) {
       int n=arr.length,ans=1;
       int []dp=new int[n];
       Arrays.fill(dp,1);
       for(int i=0;i<n;i++){
          for(int j=i;j>=0;j--){
             if(arr[j]<arr[i]){
                 dp[i]=Math.max(dp[i],dp[j]+1);
             }
          }
          ans=Math.max(ans,dp[i]);
       }
       return ans;
      
   }
}