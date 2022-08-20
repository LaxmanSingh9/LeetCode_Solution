class Solution {
     int [][]comToAdj=new int[][]{
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
    };
    public void solve(int [][]img,int st,int end,int color,int srcCol){
        if(st<0 || st>=img.length|| end<0 || end>=img[0].length || img[st][end]!=srcCol)
          return;   
        img[st][end]=color;
        for(int []com:comToAdj)
          solve(img,st+com[0],end+com[1],color,srcCol);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        solve(image,sr,sc,color,image[sr][sc]);
        return image;
        
        //call an dfs
        //call its all four direction , then so on(apply base condition also)
        //take an visited array also
    }
}