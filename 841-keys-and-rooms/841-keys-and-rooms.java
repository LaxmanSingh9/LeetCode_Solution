class Solution {
    public void dfs(List<List<Integer>>adj,boolean[]vis,int u){
          vis[u]=true;
          for(int v:adj.get(u)){
              if(!vis[v])
                dfs(adj,vis,v);
          }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []vis=new boolean[rooms.size()];
        dfs(rooms,vis,0);
        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                  return false;
            }
        }    
        return true;
        //we are given adjceny list
        //run an dfs or bfs ,start from 0 since it is unlocked
        //after dfs or bfs check weather all the rooms visited or not 
    
    }
}