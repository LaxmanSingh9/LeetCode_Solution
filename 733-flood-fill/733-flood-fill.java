class Solution {
    public void solve(int [][]img,int st,int end,int color,int srcCol,int row,int col){
        if(st<0 || st>=row|| end<0 || end>=col || img[st][end]!=srcCol)
          return;   
        img[st][end]=color;
         int [][]comToAdj=new int[][]{
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
        };
        for(int []com:comToAdj)
         solve(img,st+com[0],end+com[1],color,srcCol,row,col);
    
      }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        solve(image,sr,sc,color,image[sr][sc],image.length,image[0].length);
        return image;
        
        //call an dfs
        //call its all four direction , then so on(apply base condition also)
        //take an visited array also
    }
}