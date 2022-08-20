class Solution {
    public void solve(int [][]img,int st,int end,int color,int srcCol){
          int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0},};
          Queue<int[]>queue=new LinkedList<>();
          queue.add(new int[]{st,end});
          while(!queue.isEmpty()){
              int []mat=queue.poll();
              img[mat[0]][mat[1]]=color;
              for(int []com:comOfAdj){
                  int x=mat[0]+com[0],y=mat[1]+com[1];
                  if((x>=0 && x<img.length) && (y>=0 && y<img[0].length) && img[x][y]==srcCol){
                      queue.add(new int[]{x,y});
                    
                  }
                     
              } 
          }
          
    }
    //TC:-m*n
    //SC:-m*n
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)
            return image;
        solve(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}