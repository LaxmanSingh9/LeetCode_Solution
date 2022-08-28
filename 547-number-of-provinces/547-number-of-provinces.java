class Solution {
    public void connectedProvinces(int[][]graph,boolean[]vis,int u){
       Queue<Integer>q=new LinkedList<>();
       q.add(u);
       while(!q.isEmpty()){
           int ver=q.poll();
           vis[ver]=true;
           for(int i=0;i<graph.length;i++){
               if(!vis[i] && graph[ver][i]==1){
                    q.add(i);
               }
                  
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