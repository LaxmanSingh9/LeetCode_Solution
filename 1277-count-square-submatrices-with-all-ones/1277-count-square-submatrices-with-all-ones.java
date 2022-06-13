class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0;int min=0;
        System.out.println(m+" "+n);
        for(int i=0;i<m;i+=1){
            for(int j=0;j<n;j+=1){
                if(i==0 || j==0 || matrix[i][j]==0){
                    ans+=matrix[i][j];
                }
                else{
                 min=Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                 matrix[i][j]+=min;
                 ans+=matrix[i][j];

                }
                 
            }
        }
        return ans;
    }
}