class Solution {
    public double bfs(Map<Integer,List<Integer>>graph,int s,int end,int n,List<Map<Integer,Double>>mt){
         double []dist=new double[n];
         dist[s] = 1d;
         PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.comparingDouble(i -> -dist[i]));
         pq.add(s);
         int []vis=new int[n];
         while(!pq.isEmpty()){
           
           int u=pq.poll();
           if(u==end){
               return dist[end];
           }
           for(int e:graph.get(u)){
               if(dist[e]<dist[u]*mt.get(u).get(e)){
                   dist[e]=dist[u]*mt.get(u).get(e);
                   pq.add(e);
               }
        }
     }
     
    return 0d;
  }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<Integer>> graph = new HashMap();
        int[] visited = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
        List<Map<Integer,Double>>mt=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            mt.add(new HashMap<>());
        }
         //construct graph, add bidirectional vertex
        int i=0;
        for(int[] edge : edges){
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
           mt.get(edge[0]).put(edge[1],succProb[i]);
           mt.get(edge[1]).put(edge[0],succProb[i]);
           i+=1;
        }
		//start dfs from start point
        return bfs(graph,start,end,n,mt);
    }
}