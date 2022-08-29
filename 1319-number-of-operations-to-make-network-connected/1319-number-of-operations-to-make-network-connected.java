class Solution {
    //To connected n nodes , we al least need n-1 unique edges
    //if there are n-1 edges then minimum opeation will be total disconnected componets in graph
    public void dfs(ArrayList<ArrayList<Integer>>adjList,boolean []vis,int u){
        vis[u]=true;
        for(int v:adjList.get(u)){
            if(!vis[v])
                dfs(adjList,vis,v);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int totalConnections=connections.length;
        if(totalConnections<n-1)
            return -1;
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int []con:connections){
            adjList.get(con[0]).add(con[1]);
            adjList.get(con[1]).add(con[0]);
        }
        boolean[]vis=new boolean[n];
        int totalComponents=0;
        for(int i=0;i<n;i+=1){
            if(!vis[i]){
                dfs(adjList,vis,i);
                totalComponents+=1;
            }
        }
        return totalComponents-1;//TotalDisconnectedComponents-1
    }
}