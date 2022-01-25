class Solution {
    public boolean bfs(Map<Integer,List<Integer>>graph,int[] v,int s,int e){
         Queue<Integer>queue=new LinkedList<>();
         queue.add(s);
         while(!queue.isEmpty()){
             s=queue.poll();
             if(s==e){
                 return true;
             }
             v[s]=1;
             for(int node:graph.get(s)){
                 if(v[node]!=1){
                     queue.add(node);
                 }
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
		//start bfs from start point
        return bfs(graph,visited,source,destination);
       
        
    }
}