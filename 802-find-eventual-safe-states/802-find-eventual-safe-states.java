class Solution {
  
    public boolean hasCycle(int s,int[][]graph,int[]v,int []rest,int[]dp){
        if(dp[s]==-1){
            return true;
        }
        v[s]=1;
        rest[s]=1;
        for(int e:graph[s]){
            if(v[e]!=1 && hasCycle(e,graph,v,rest,dp)==true){
               return true;
            }
            else if(rest[e]==1){
                return true;
            }
        }
        rest[s]=0;
        return false;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        
        List<Integer>ans=new ArrayList<>();
        int []v=new int[n];
        int []rest=new int[n];
        int []dp=new int[n];
        for(int i=0;i<n;i+=1){
            if(hasCycle(i,graph,v,rest,dp)==false){
                ans.add(i);
            }
            else{
                dp[i]=-1;
            }
        } 
       return ans;
    }

}