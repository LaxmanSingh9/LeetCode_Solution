class Solution {
    public void convOnesToZeros(int[][]grid,Integer rowN,Integer colN){
        if(rowN<0 || rowN>=grid.length || colN<0 || colN>=grid[0].length || grid[rowN][colN]!=1)
            return;
        grid[rowN][colN]=0;
        convOnesToZeros(grid,rowN+1,colN);
        convOnesToZeros(grid,rowN-1,colN);
        convOnesToZeros(grid,rowN,colN+1);
        convOnesToZeros(grid,rowN,colN-1);
        
    }
    public int numEnclaves(int[][] grid) {
        int rows=grid.length,cols=grid[0].length,cntLandsToMove=0;
        //covert boundry ones to zeros
        //For col 0 and cols-1
        for(int i=0;i<rows;i++){
            if(grid[i][0]==1)
               convOnesToZeros(grid,i,0);
            if(grid[i][cols-1]==1)
                convOnesToZeros(grid,i,cols-1);         
       }
       //covert boundry ones to zeros
        //For row 0 and rows-1
       for(int i=0;i<cols;i++){
            if(grid[0][i]==1)
               convOnesToZeros(grid,0,i);
            if(grid[rows-1][i]==1)
               convOnesToZeros(grid,rows-1,i);         
       }
       //count all the ones , which are  land to move
       for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
             if(grid[i][j]==1)
                 cntLandsToMove+=1;
         }
       }
       return  cntLandsToMove;
    }
}