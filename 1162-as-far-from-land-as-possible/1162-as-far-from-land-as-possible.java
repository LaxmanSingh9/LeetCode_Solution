class Solution {
    public int findMaxDistance(int[][]arr){
        int maxDis=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                maxDis=Math.max(maxDis,arr[i][j]);
            }
        }
        return maxDis==Integer.MAX_VALUE || maxDis==0?-1:maxDis;
    }
    public int maxDistance(int[][] graph) {
        int m=graph.length,n=graph[0].length;
        int [][]dist=new int[m][n];
        int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int []ar:dist)
            Arrays.fill(ar,Integer.MAX_VALUE);
        Queue<int[]>queue=new LinkedList<>();
        for(int u=0;u<m;u++){
            for(int v=0;v<n;v++){
                if(graph[u][v]==1){
                    dist[u][v]=0;
                    queue.add(new int[]{u,v});
                }
            }
        }
        while(!queue.isEmpty()){
           int[]node=queue.poll(); 
           int u=node[0],v=node[1],x=0,y=0;
           for(int k=0;k<4;k++){
               x=u+comOfAdj[k][0];y=v+comOfAdj[k][1];
               if((x>=0 && x<m)&&(y>=0 && y<n) &&(dist[x][y]>dist[u][v]+1)){
                   dist[x][y]=dist[u][v]+1;
                   queue.add(new int[]{x,y});
                   
               }
           }
            
        }
        return findMaxDistance(dist);
        
    }
}