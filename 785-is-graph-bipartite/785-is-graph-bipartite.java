class Solution {
    public boolean isGraphBipartite(int[][]graph,int[] colorArr,int u,int col){
        Queue<Integer>queue=new LinkedList<>();
        queue.add(u);
        colorArr[u]=col;
        while(!queue.isEmpty()){
            int ver=queue.poll();
            for(int v:graph[ver]){
                if(colorArr[v]==0){
                  queue.add(v);
                  colorArr[v]=-colorArr[ver];
                }
                else if(colorArr[ver]==colorArr[v])
                   return false;
            }
            
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        if(n==1)
          return true;
        int[]colorArr=new int[n];
        for(int i=0;i<n;i++){
          if(colorArr[i]==0 && !isGraphBipartite(graph,colorArr,i,1))
                return false;
        }
        return true;
    }
}