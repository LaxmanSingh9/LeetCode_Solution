class Solution {
   public int bfs(Map<Integer,List<Integer>>graph,int n,int s,int []dist,int[][]mt){
         PriorityQueue<int[]>pq=new PriorityQueue<>((a, b) -> (a[1] - b[1]));
         dist[s]=0;int cnt=0;pq.add(new int[]{s,0});
         int ans=0;
         while(!pq.isEmpty()){
           int []c=pq.remove();
           int u=c[0];int d1=c[1];
           if(dist[u]<d1){continue;}
           ans=dist[u];n-=1;
           for(int e:graph.get(u)){
               
               if(dist[e]>dist[u]+mt[u][e]){
                   dist[e]=dist[u]+mt[u][e];
                   pq.add(new int[]{e,dist[e]});
               }
         }
      }
      return n== 0 ? ans : -1;

  }
    public int networkDelayTime(int[][] edges, int n, int k) {
        
        Map<Integer,List<Integer>> graph = new HashMap();
        int[] dist= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        int [][]edgeWeight=new int[n][n];
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
         //construct graph, add bidirectional vertex
        for(int[] edge : edges){
           graph.get(edge[0]-1).add(edge[1]-1);
           edgeWeight[edge[0]-1][edge[1]-1]=edge[2];
        }
        return bfs(graph,n,k-1,dist,edgeWeight);
        
        
    }
}