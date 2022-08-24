class Solution {
    int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0},};
    public void dfs(int[][]graph,int[][]dist,int u,int v,int prev){
        dist[u][v]=prev;
        for(int []com:comOfAdj){
            int x=u+com[0],y=v+com[1];
            if((x>=0&&x<graph.length) && (y>=0 && y<graph[0].length)&& graph[x][y]!=0 && (dist[x][y]>dist[u][v]+1))
               dfs(graph,dist,x,y,dist[u][v]+1);
        }
    }
    public int[][] updateMatrix(int[][] mat) {
         int m=mat.length,n=mat[0].length;
         int [][]dist=new int[m][n];
         for(int []ar:dist)
             Arrays.fill(ar,Integer.MAX_VALUE);
        
         for(int i=0;i<m;i+=1){
            for(int j=0;j<n;j+=1){
                if(mat[i][j]==0){
                    dfs(mat,dist,i,j,0);
                }
            }
         }
    
         return dist;
        
        
        
        //Run an dfs or bfs for all the zeros and keep update the distance
        
        
    }
}