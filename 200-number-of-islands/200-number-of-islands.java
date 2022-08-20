class Solution {
     int [][]comToAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(char [][]grid,int rowN,int colN){
        if(grid[rowN][colN]!='1')
            return;
        grid[rowN][colN]='2';
        for(int []com:comToAdj){
           int adjRow=rowN+com[0],adjCol=colN+com[1];
           if((adjRow>=0 && adjRow<grid.length)&&(adjCol>=0 && adjCol<grid[0].length))                                dfs(grid,adjRow,adjCol);
         }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i+=1){
            for(int j=0;j<grid[0].length;j+=1){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
        //Iterarte for all the matrix ele which have 1 
          //and run an dfs and explore all the adj nodes and mark them unvisited
          //increase the count of islands
    }
}