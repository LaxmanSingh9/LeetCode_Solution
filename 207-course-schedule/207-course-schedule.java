class Solution {
    public boolean hasCycle(Map<Integer,List<Integer>>graph,int s,int[]vis,int []rest){
        if(vis[s]==1){
            return rest[s]==1;
        }
        vis[s]=1;
        rest[s]=1;
        for(int e:graph.get(s)){
            if(hasCycle(graph,e,vis,rest)){
                return true;
            }
        }
        rest[s]=0;
        return false;
        
        
        
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         int n=numCourses;
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
        int []inDeg=new int[n];
        for(int edges[]:prerequisites){
            graph.get(edges[1]).add(edges[0]);
            
        }
        int []visited=new int[n];
        int []rest=new int[n];
        for(int i=0;i<n;i+=1){
            if(visited[i]!=1 && hasCycle(graph,i,visited,rest)){
                return false;
            }
        }
        return true;
    }
}