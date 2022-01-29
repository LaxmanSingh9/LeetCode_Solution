class Solution {
    public boolean dfs(Map<Integer,List<Integer>>graph,int[]visited,int s,int d){
        if(s==d){
            return true;
        }
        visited[s]=1;
        for(int edge:graph.get(s)){
            if(visited[edge]!=1){
                if(dfs(graph,visited,edge,d))
                    return true;
            }
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap();
        int n=edges.length;
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
         //construct graph, add bidirectional vertex
        for(int[] edge : edges){
           if(graph.get(edge[0]-1)!=null && graph.get(edge[1]-1)!=null){
              
               boolean  check=dfs(graph,new int[n],edge[0]-1,edge[1]-1);
               if(check==true){
                   return edge;
               }
                   
               
           } 
           graph.get(edge[0]-1).add(edge[1]-1);
           graph.get(edge[1]-1).add(edge[0]-1);
        }
		//start dfs from start point
       throw new AssertionError();
        
    }
}