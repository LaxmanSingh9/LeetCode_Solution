class Solution {
    public int bfs(Map<Integer,List<Integer>>graph,int ds,int s,int n,int[][]mt){
         PriorityQueue<int[]>pq=new PriorityQueue<>((a, b) -> (a[1] - b[1]));
         int []dist=new int[n];Arrays.fill(dist,100000);
         dist[s]=0;int cnt=0;pq.add(new int[]{s,0});
         while(!pq.isEmpty()){
           int []c=pq.remove();
           int u=c[0];int d1=c[1];
           if(dist[u]<d1){continue;}
           if(dist[u]<=ds){
               cnt+=1;
           }
          
           for(int e:graph.get(u)){
               
               if(dist[e]>dist[u]+mt[e][u]){
                   dist[e]=dist[u]+mt[e][u];
                   pq.add(new int[]{e,dist[e]});
               }
        }
     }
     
    return cnt-1;
  }
    
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
              
        Map<Integer,List<Integer>> graph = new HashMap();
        
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
        int [][]mt=new int[n][n];
         //construct graph, add bidirectional vertex
        for(int[] edge : edges){
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
           mt[edge[0]][edge[1]]=edge[2];
           mt[edge[1]][edge[0]]=edge[2];
        }
        int min=Integer.MAX_VALUE;
       
        int ans=0;
        for(int i=0;i<n;i+=1){
              int min_nodes=bfs(graph, distanceThreshold, i,n,mt);
               //System.out.println(min_nodes);
               if(min_nodes<=min){
                     ans=i;
                     min=min_nodes;
                 }
                 
       }
       return ans;
        
    }
}