class Solution {
    public void bfs(char [][]img,int rowN,int colN){
       int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
       Queue<int[]>queue=new LinkedList<>();
       queue.add(new int[]{rowN,colN});
       img[rowN][colN]='2';
       while(!queue.isEmpty()){
           int []mat=queue.poll();
           
          for(int []com:comOfAdj){
                  int x=mat[0]+com[0],y=mat[1]+com[1];
                  if((x>=0 && x<img.length) && (y>=0 && y<img[0].length) && img[x][y]=='1'){
                      queue.add(new int[]{x,y});
                      img[x][y]='2';
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