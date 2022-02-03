class Solution {
  
    public boolean hasCycle(int s,int[][]graph,int[]v){
        if(v[s]!=0){
            return v[s]==1;
        }
        v[s]=1;
        for(int e:graph[s]){
            if(hasCycle(e,graph,v)==true){
               return true;
            }
         
        }
        v[s]=2;
        return false;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer>ans=new ArrayList<>();int []v=new int[n];
        for(int i=0;i<n;i+=1){
            if(hasCycle(i,graph,v)==false)
              ans.add(i);
            
        } 
       return ans;
    }

}