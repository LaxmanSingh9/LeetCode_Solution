class Solution {
    public void dfs(int[][]graph,int[]visited,int s,int n){
        visited[s]=1;
        for(int i=0;i<n;i+=1){
            if(visited[i]!=1&&(graph[s][i]==1 || graph[i][s]==1)){
                dfs(graph,visited,i,n);
            }
        }
        
    }
    public int findCircleNum(int[][] graph) {
        int ans=0;
        int n=graph.length;
        int []visited=new int[n];
        for(int i=0;i<n;i+=1){
            if(visited[i]!=1){
                dfs(graph,visited,i,n);
                ans+=1;
            }
        }
        return ans;
        
    }
}