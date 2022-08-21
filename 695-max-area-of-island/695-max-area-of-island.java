class Solution {
    
    int [][]comToAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int dfs(int [][]grid,int rowN,int colN){
        if(rowN<0 || rowN>=grid.length || colN<0 || colN>=grid[0].length||grid[rowN][colN]!=1)
            return 0;
        grid[rowN][colN]=2;
        return (1+dfs(grid,rowN+1,colN)+dfs(grid,rowN-1,colN)+dfs(grid,rowN,colN+1)
              +dfs(grid,rowN,colN-1));
        
    }
    public int maxAreaOfIsland(int[][] grid) {
       int maxArea=0;
       for(int i=0;i<grid.length;i+=1){
            for(int j=0;j<grid[0].length;j+=1){
                if(grid[i][j]==1)
                    maxArea=Math.max(maxArea,dfs(grid,i,j));
            }
       }
       return maxArea;
        
    }
}