class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n=scores.length;int ans=1;
        int []dp=new int [n];
        int [][]arr=new int[n][2];
        for(int i=0;i<n;i+=1){
            arr[i][0]=ages[i];
            arr[i][1]=scores[i];
        }
        Arrays.sort(arr, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        dp[0]=arr[0][1];ans=dp[0];
        for(int i=1;i<n;i+=1){
          dp[i]=arr[i][1];
          for(int j=i-1;j>=0;j-=1){
              if(arr[i][1]>=arr[j][1]){  //age is equal than choose the equal or bigger candi.
                  dp[i]=Math.max(dp[i],dp[j]+arr[i][1]);
              }
           }
           ans=Math.max(ans,dp[i]);
                                          
         }
      
       return ans;
}
                                                                   
        }