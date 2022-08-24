class Solution {
    public boolean isPartOfAnCycle(Integer v,boolean[]vis,int[][]graph,int[]recSt){
        if(recSt[v]!=0)
            return recSt[v]==1;
        vis[v]=true;
        recSt[v]=1;
        for(Integer u:graph[v]){
            if(recSt[u]==1 || isPartOfAnCycle(u,vis,graph,recSt))
                return true;
        }
        recSt[v]=2;
        return false;
        
    }
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<Integer>result=new ArrayList<>(); 
        int []recSt=new int[V];//1=part of cycle,2=not part of cycle
        boolean []vis=new boolean[V];//false=not visited yet , true=visited 
        for(int v=0;v<V;v+=1){
            if(!isPartOfAnCycle(v,vis,graph,recSt))
                result.add(v);
        }    
        return result;
        
        //will run an cycle detectcion algo for all the nodes
        // if an node is an part of cycle that means ,it will not lead to an terminal node
        
        
    }
}