class Solution {
    public int maximalNetworkRank(int n, int[][] edges) {
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
        int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                if(i==j){
                    continue;
                }
                int totalEdgesBetVertices=graph.get(i).size()+graph.get(j).size();
                if(graph.get(i).contains(j)){
                    totalEdgesBetVertices-=1;
                }
                ans=Math.max(totalEdgesBetVertices,ans);
            }
        }
        return ans;
    }
}