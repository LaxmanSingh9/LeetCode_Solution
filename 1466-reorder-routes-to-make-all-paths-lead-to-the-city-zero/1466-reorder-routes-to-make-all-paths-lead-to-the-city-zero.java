class Solution {
    public int dfs(Map<Integer,List<Integer>>graph,int[]visited,int s){
        visited[s]=1;
        int cost=0;
        for(var edge:graph.get(s)){
            if(visited[Math.abs(edge)]!=1){
                cost+=dfs(graph,visited,Math.abs(edge))+(edge>0?1:0);
            }
        }
        return cost;
    }
    public int minReorder(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap();
        int[] visited = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
         //construct graph, add bidirectional vertex
        for(int[] edge : edges){
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(-edge[0]);
        }
		//start dfs from start point
       return dfs(graph,visited,0);
       
        
    }
}