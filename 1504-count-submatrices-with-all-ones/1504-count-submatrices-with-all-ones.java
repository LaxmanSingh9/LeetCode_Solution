class Solution {
    public int numSubmat(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;
        for(int i=0;i<m;i+=1){
            for(int j=0;j<n;j+=1){
               int limit=n;
               for(int i1=i;i1<m;i1+=1){
                   for(int j1=j;j1<limit;j1+=1){
                       if(matrix[i1][j1]==1){
                           ans+=1;
                       }
                       else{
                           limit=j1;
                       }
                   }
               }
            }
        }
        return ans;
        
    }
}