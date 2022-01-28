class Solution {
    public void dfs(List<List<Integer>>graph,int s,int[]visited){
        visited[s]=1;
        
        for(int edge:graph.get(s)){
            if(visited[edge]!=1)
                dfs(graph,edge,visited);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> graph) {
        
      int n=graph.size();
      int[] visited = new int[n];
      dfs(graph,0,visited);
      for(int i=0;i<n;i+=1){
        if(visited[i]==0 &&i!=0)
            return false;
       }
       return true;

        
    }
}