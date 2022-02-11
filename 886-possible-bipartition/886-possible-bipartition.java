class Solution {
    public boolean dfs(Map<Integer,List<Integer>>graph,int s,int[]vis,int col){
        if(vis[s]!=-1)
            return vis[s]==col;
        vis[s]=col;
        for(int e:graph.get(s)){
            if(dfs(graph,e,vis,col^1)==false)
              return false;
        }
    
        return true;
    
    
    }
    
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
        for(int edges[]:dislikes){
            graph.get(edges[0]-1).add(edges[1]-1);
            graph.get(edges[1]-1).add(edges[0]-1);
        }
        int []vis=new int[n];Arrays.fill(vis,-1);
        for(int i=0;i<n;i+=1){
            if(vis[i]==-1 && dfs(graph,i,vis,0)==false)
                return false;
        }
        return true;
    
    
    
    }
}