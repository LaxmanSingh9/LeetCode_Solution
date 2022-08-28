class Solution {
    public boolean hasPath(int [][]graph,boolean[]vis,int u,int v){
        if(u==v)
            return true;
        vis[u]=true;
        for(int i=0;i<graph.length;i++){
           if(graph[u][i]==1 && !vis[i] && hasPath(graph,vis,i,v))
              return true;
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int [][]graph=new int[n][n];
        boolean []vis;
        for(int []edge:edges){
            vis=new boolean[n];
            if(hasPath(graph,vis,edge[0]-1,edge[1]-1)){
               return edge;  
            }
            graph[edge[0]-1][edge[1]-1]=1;
            graph[edge[1]-1][edge[0]-1]=1;
           
        }
        return new int[0];
    }
}