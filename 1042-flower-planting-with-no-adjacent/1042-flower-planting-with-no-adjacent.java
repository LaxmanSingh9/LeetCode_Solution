class Solution {
    public boolean dfs(Map<Integer,List<Integer>>graph,int s,int n,int[]vis,int c){
        if(vis[s]!=0){
            return vis[s]==c;
        }
        
        for(int e:graph.get(s)){
            if(vis[e]==c){
                return false;
            }
        }
        if(vis[s]!=0){
            
            return true;
        }
        vis[s]=c;
        for(int e:graph.get(s)){
            boolean flag=false;
            for(int i=1;i<=n;i+=1){
                flag=dfs(graph,e,n,vis,i);
                if(flag==true){
                    break;
                }
            }
        }
        return true;
        
        
    }
    public int[] gardenNoAdj(int n, int[][] edges) {
        Map<Integer,List<Integer>> graph = new HashMap();
        int[] vis= new int[n+1];
        
        for(int i = 0 ; i <=n ; i++){
            graph.put(i, new ArrayList());
        }
        for(int[] edge : edges){
           graph.get(edge[0]).add(edge[1]);
           graph.get(edge[1]).add(edge[0]);
        }
        for(int i=1;i<=n;i+=1){
            if(vis[i]==0){
                  dfs(graph,i,n,vis,1);
            }
        }
      
        return  Arrays.copyOfRange(vis, 1,n+1);
        
    }
}