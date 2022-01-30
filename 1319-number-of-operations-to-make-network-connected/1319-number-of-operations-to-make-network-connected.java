class Solution {
    int vertices=0;
    int edge=0;
    public void dfs(Map<Integer,List<Integer>>graph,int []v,int s){
        v[s]=1;
        vertices+=1;
         
        for(int e:graph.get(s)){
           edge+=1;
           if(v[e]!=1){
                dfs(graph,v,e);
            }
        }
        
    }
    public int makeConnected(int n, int[][] edges) {
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
        int com=0;int extra=0;
	    for(int i=0;i<n;i+=1){
            if(visited[i]!=1){
                com+=1;edge=0;vertices=0;
               //System.out.println(edge+" "+vertices);
                dfs(graph,visited,i);
               // System.out.println(edge+" "+vertices);
                extra+=edge/2-(vertices-1);
            }
        }
        if(com-1<=extra){
            return com-1;
        }
        return -1;
        
    }
}