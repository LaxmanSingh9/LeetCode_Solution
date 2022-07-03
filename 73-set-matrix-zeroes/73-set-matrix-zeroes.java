class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        Set<Integer>col=new HashSet<Integer>();
         Set<Integer>row=new HashSet<Integer>();
        for(int i=0;i<n;i+=1){
            for(int j=0;j<m;j+=1){
                if(matrix[i][j]==0){
                    row.add(i);col.add(j);
                }
                    
            }
       } 
       for(int i=0;i<n;i+=1){
           for(int j=0;j<m;j+=1){
               if(row.contains(i) || col.contains(j)){
                   matrix[i][j]=0;
               }
             
           }
       }
    }
}
               
    