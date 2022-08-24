class Solution {
    int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length,n=mat[0].length;
        Queue<int[]>queue=new LinkedList<>();
        for(int u=0;u<m;u++){
          for(int v=0;v<n;v++){
              if(mat[u][v]==0) queue.add(new int[]{u,v});
              else  mat[u][v]=Integer.MAX_VALUE;
          }
        }
        while(!queue.isEmpty()){
            int []node=queue.poll();
            int u=node[0],v=node[1],x=0,y=0;
            for(int i=0;i<4;i++){
                x=u+comOfAdj[i][0];
                y=v+comOfAdj[i][1];
                if((x>=0 && x<m) && (y>=0 && y<n) && mat[x][y]!=0 && mat[x][y]>mat[u][v]+1){
                    mat[x][y]=mat[u][v]+1;
                    queue.add(new int[]{x,y});
                }
            }
            
        }
        return mat;
    }
}