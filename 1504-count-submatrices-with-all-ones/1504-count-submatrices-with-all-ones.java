class Solution {
    public int numSubmat(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i+=1){
          for(int j=n-1;j>=0;j-=1){
              if(j==n-1){
                  dp[i][j]=matrix[i][j];
              }
              else if(matrix[i][j]==1){
                  dp[i][j]=dp[i][j+1]+1;
              }
              else{
                  dp[i][j]=0;
              }
              
          }
        } 
        int minn,row;
        for(int i=0;i<m;i+=1){
            for(int j=0;j<n;j+=1){
                  row=i;
                  minn=Integer.MAX_VALUE;
                  while( row<m && dp[row][j]>0){
                      minn=Math.min(dp[row][j],minn);
                      row+=1;
                      ans+=minn;
                  }
                 
            }
        }
        return ans;
        
    }
}