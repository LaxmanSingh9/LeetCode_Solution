class Solution {
    public void dfs(List<List<Integer>>graph,int[] visited,int s,int[]answer){
        visited[s]=1;
        answer[s]+=1;
        for(int edge:graph.get(s)){
            if(visited[edge]!=1)
                dfs(graph,visited,edge,answer);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> graph) {
        
      int n=graph.size();
      int[] visited = new int[n];
      int []answer=new int[n];    
        for(int i=0;i<n;i+=1){
            if(visited[i]!=1){
                dfs(graph,visited,i,answer);
                answer[i]-=1;
    
            }
              
        }  
        for(int i=0;i<n;i+=1){
            if(answer[i]<=0 &&i!=0)
              return false;
        }
        return true;

        
    }
}