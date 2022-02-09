class Solution {
    public boolean dfs(int [][]graph,int []vis,int col,int s){
        if(vis[s]!=-1){
            return vis[s]==col?true:false;
        }
        vis[s]=col;
        for(int e:graph[s]){
          boolean check=dfs(graph,vis,col==0?1:0,e);
          if(check==false){
                return false;
            }
        }
        return true;
        
    }
    public boolean isBipartite(int[][] graph) {
       int n=graph.length;
       int []vis=new int[n];
       Arrays.fill(vis,-1);
       for(int i=0;i<n;i+=1){
         if(vis[i]==-1 && !dfs(graph,vis,0,i))
             return false;
       }
       return true;
    }
    
}