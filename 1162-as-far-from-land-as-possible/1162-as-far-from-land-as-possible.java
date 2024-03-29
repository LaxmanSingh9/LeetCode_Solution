class Solution {
     public int maxDistance(int[][] graph) {
        int m=graph.length,n=graph[0].length;
        int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]>queue=new LinkedList<>();
        for(int u=0;u<m;u++){
            for(int v=0;v<n;v++){
                if(graph[u][v]==1){
                    queue.add(new int[]{u,v});
                }
            }
        }
        if(queue.size()==m*n || queue.size()== 0)
           return -1;
        int dist=0,maxDis=0;
        while(!queue.isEmpty()){
            int size=queue.size(); 
            dist++;
            while(size-->0){
              int[]node=queue.poll();
              int x=node[0],y=node[1];
              for(int k=0;k<4;k++){
                int newX=x+comOfAdj[k][0];
                int newY=y+comOfAdj[k][1];
                if((newX>=0 && newX<m)&&(newY>=0 && newY<n) && graph[newX][newY]==0){
                   graph[newX][newY]=dist;
                   queue.add(new int[]{newX,newY});
                }
             }
            }
        }
        for(int i=0;i<m;i++){
          for(int j=0;j<n;j++){
              maxDis=Math.max(graph[i][j],maxDis);
          }
        }
        return maxDis;
    }
}