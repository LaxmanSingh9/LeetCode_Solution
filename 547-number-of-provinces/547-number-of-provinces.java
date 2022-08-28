class Solution {
    public void connectedProvinces(int[][]graph,boolean[]vis,int u){
        vis[u]=true;
        for(int i=0;i<graph.length;i++){
            if(!vis[i] && graph[u][i]==1){
                connectedProvinces(graph,vis,i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected){
        int provinces=0,n=isConnected.length;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                connectedProvinces(isConnected,vis,i);
                provinces++;
            }
        }
        return provinces;
    }
}