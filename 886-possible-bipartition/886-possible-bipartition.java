class Solution {
    public void addEdge(ArrayList<ArrayList<Integer>>adj,int u,int v){
        adj.get(u-1).add(v-1);
        adj.get(v-1).add(u-1);
    }
    public boolean checkBiPartitions(ArrayList<ArrayList<Integer>>graph,int []colorArr,int u,int col){
        colorArr[u]=col;
        for(int v:graph.get(u)){
            if(colorArr[v]==-1 && !checkBiPartitions(graph,colorArr,v,col^1))
                return false;
            else if(colorArr[u]==colorArr[v])
                return false;
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(n==1  || dislikes.length==0)
            return true;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int []colorArr=new int[n];
        Arrays.fill(colorArr,-1);
        for(int i=0;i<n;i+=1)
            adj.add(new ArrayList<>());
        for(int i=0;i<dislikes.length;i++)
            addEdge(adj,dislikes[i][0],dislikes[i][1]);
        for(int i=0;i<n;i+=1){
            if(colorArr[i]==-1 && !checkBiPartitions(adj,colorArr,i,1))
                return false;
        }
        return true;
    }
}