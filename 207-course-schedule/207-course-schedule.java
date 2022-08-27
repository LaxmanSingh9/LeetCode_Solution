class Solution {
    public boolean doesContainCycle(ArrayList<ArrayList<Integer>>adj,boolean []visited,int []recSt,int u){
        visited[u]=true;
        recSt[u]=1;
        for(int v:adj.get(u)){
            if(!visited[v] && doesContainCycle(adj,visited,recSt,v))
                return true;
            if(recSt[v]==1)
                return true;
        }
        recSt[u]=2;
        return false;
        
}
    public boolean canFinish(int n, int[][] prerequisites) {        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        for(int []pre:prerequisites)
            adj.get(pre[0]).add(pre[1]);
        boolean []visited=new boolean[n];
        int [] recSt=new int[n];
        for(int i=0;i<n;i++){
            if(!visited[i] && doesContainCycle(adj,visited,recSt,i))
                return false;
            else if(visited[i] && recSt[i]==1)
                return false;
        }
        return true;
        
     }
}