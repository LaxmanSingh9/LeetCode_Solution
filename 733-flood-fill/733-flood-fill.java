class Solution {
    int [][]comToAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0},};
    public void solve(int [][]img,int st,int end,int color,int srcCol){
        if(img[st][end]!=srcCol)
            return;
        img[st][end]=color;
        for(int[]c:comToAdj){
          if((st+c[0]>=0 && st+c[0]<img.length)&&(end+c[1]>=0 && end+c[1]<img[0].length))
             solve(img,st+c[0],end+c[1],color,srcCol); 
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        solve(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}