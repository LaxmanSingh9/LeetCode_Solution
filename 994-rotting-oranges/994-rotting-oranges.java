class Solution {
     int [][]comOfAdj=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] graph) {
        
        int m=graph.length,n=graph[0].length;
        Queue<int[]>queue=new LinkedList<>();
        int freshOrg=0;
        for(int u=0;u<m;u++){
          for(int v=0;v<n;v++){
              if(graph[u][v]==2){
                  graph[u][v]=0;
                  queue.add(new int[]{u,v});
              }
              else if(graph[u][v]==1){
                  freshOrg+=1;
              }
          }
        }
        if(queue.size()==0 && freshOrg>0){
             return -1; 
        }
        if(freshOrg==0)
            return 0;
        int dist=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            dist++;
            while(size-->0){
                int[]node=queue.poll();
                int x=node[0],y=node[1];
                for(int i=0;i<4;i+=1){
                    int newX=x+comOfAdj[i][0];
                    int newY=y+comOfAdj[i][1];
                    if((newX>=0 &&  newX<m)&&(newY>=0 && newY<n)&& graph[newX][newY]!=0){
                        freshOrg-=1;
                        graph[newX][newY]=0;
                        queue.add(new int[]{newX,newY});
                    }
                }
                
            }
            
        }
        return freshOrg==0?dist-1:-1;
        
    }
}