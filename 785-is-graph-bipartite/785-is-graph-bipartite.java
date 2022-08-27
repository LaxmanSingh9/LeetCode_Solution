class Solution {
    public boolean isGraphBipartite(int[][]graph,int[] colorArr,int u,int col){
        colorArr[u]=col;
        for(int v:graph[u]){
            if(colorArr[v]==0 && !isGraphBipartite(graph,colorArr,v,-col))
              return false;
            else if(colorArr[u]==colorArr[v])
              return false;
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