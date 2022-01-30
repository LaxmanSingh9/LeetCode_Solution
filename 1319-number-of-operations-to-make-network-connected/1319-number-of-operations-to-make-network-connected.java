class Solution {
    
    public void dfs(Map<Integer,List<Integer>>graph,int []v,int s){
        v[s]=1;
        for(int e:graph.get(s)){
           if(v[e]!=1) dfs(graph,v,e);
            
        }
        
    }
    public int makeConnected(int n, int[][] edges) {
        if(edges.length<n-1){
            return -1;
        }
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
        int com=0;
	    for(int i=0;i<n;i+=1){
            if(visited[i]!=1){
                dfs(graph,visited,i);    //count the componenets 
                com+=1;
            }
        }
        return com-1;
        
    }
}