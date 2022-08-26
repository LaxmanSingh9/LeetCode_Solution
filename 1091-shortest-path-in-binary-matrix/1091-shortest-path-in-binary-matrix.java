class Solution {
     int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,-1},{-1,1}};
    public void findShortestClearPath(int [][]graph,int[][]dist,int u,int v,int prev){
       dist[u][v]=prev; 
       for(int i=0;i<8;i+=1){
           int newU=u+comOfAdj[i][0];
           int newV=v+comOfAdj[i][1];
           if((newU>=0&&newU<graph.length)&&(newV>=0&&newV<graph[0].length)&&graph[newU][newV]!=1&&dist[newU][newV]>prev+1){
               findShortestClearPath(graph,dist,newU,newV,prev+1);
           }
       } 
        
    }
    public int shortestPathBinaryMatrix(int[][] graph) {
      if(graph[0][0]!=0)
          return -1;
      int m=graph.length,n=graph[0].length;  
      Queue<int[]>queue=new LinkedList<>();
      queue.add(new int[]{0,0});
      int dist=0;
      while(!queue.isEmpty()){
          int size=queue.size();
          dist++;
          while(size-->0){
              int node[]=queue.poll();
              int u=node[0],v=node[1];
              if(u==n-1 && v==n-1)
                  return dist;
               for(int i=0;i<8;i+=1){
                  int newU=u+comOfAdj[i][0];
                  int newV=v+comOfAdj[i][1];
                  if((newU>=0&&newU<graph.length)&&(newV>=0&&newV<graph[0].length)&&graph[newU][newV]!=1){
                      graph[newU][newV]=1;
                      queue.add(new int[]{newU,newV});
                 }
              }
              
          }
      }
      return -1;
    
     //will call an dfs for cell (0,0)
     //will explore all the 8 directions , find the minimum clear path
    }
}