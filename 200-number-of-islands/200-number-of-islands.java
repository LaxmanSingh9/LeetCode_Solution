class Solution {
    public void bfs(char [][]grid,int rowN,int colN){
       int [][]comToAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
       Queue<int[]>queue=new LinkedList<>();
       queue.add(new int[]{rowN,colN});
       grid[rowN][colN]='2';
       while(!queue.isEmpty()){
          int []mat=queue.poll();
          for(int []com:comToAdj){
            int adjRow=mat[0]+com[0],adjCol=mat[1]+com[1];
            if((adjRow>=0 && adjRow<grid.length)&&(adjCol>=0 && adjCol<grid[0].length)&& grid[adjRow][adjCol]=='1'){
                queue.add(new int[]{adjRow,adjCol});
                grid[adjRow][adjCol]='2';
            }
        }
      }
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i+=1){
            for(int j=0;j<grid[0].length;j+=1){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
        //Iterarte for all the matrix ele which have 1 
          //and run an bfs or dfs and explore all the adj nodes and mark them unvisited
          //increase the count of islands
    }
}