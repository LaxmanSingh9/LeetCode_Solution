 
    //Brute Force
     //  1.Run for all the nodes
     //  2.Check does this gives an cycel or not
     //  3. if node has an cycle exculde from result
     //  TC=>O(V*(V+E)),RSC=O(V+E)
    //Efficent Solution 
     // To make it effiecent , we will keep track of an node has an cycle or not
     //  we will avoid call for already hasCycle or non-hasCycle nodes
     //TC=>O(V+E) ,SC=>O(V)
    //Space Optimized Solution
    //we can use also one array to track both visited and hasCycle or not

class Solution {
   public boolean isPartOfAnCycle(Integer v,boolean[]vis,int[][]graph,int[]recSt){
        if(recSt[v]!=0)          //Avoid call for cycle nodes or non-cycle node
            return recSt[v]==1;
        vis[v]=true;
        recSt[v]=1;
        for(Integer u:graph[v]){
           if(vis[u]==false && isPartOfAnCycle(u,vis,graph,recSt))
                return true;
            if(recSt[u]==1 )
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