class Solution {
    public boolean dfs(Map<Integer,List<Integer>>graph,int[] v,int s,int e){
         if(s==e){
             return true;
         }
         if(v[s]==1){
             return false;
         }
         v[s]=1;
         for(int node:graph.get(s)){
            if(dfs(graph,v,node,e)){
               return true;
               
            }
             
         }
         return false;
          
        
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
         
        Map<Integer,List<Integer>> graph = new HashMap();
        int[] visited = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
         //construct graph, add bidirectional vertex
        for(int[] edge : edges){
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
        }
		//start dfs from start point
        return dfs(graph,visited,source,destination);
       
        
    }
}