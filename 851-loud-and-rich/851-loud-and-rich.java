class Solution {
    public  int dfs(Map<Integer,List<Integer>>graph,int[]ans,int s,int[]quiet){
         if(ans[s]!=-1){
             return ans[s];
         }
         else{
           ans[s]=s;
           for(int edge:graph.get(s)){
               if(quiet[ans[s]]>quiet[dfs(graph,ans,edge,quiet)]){
                   ans[s]=ans[edge];
                   
               }
               
           }  
           return ans[s];
         }
        
         
    }
    public int[] loudAndRich(int[][] edges, int[] quiet) {
         Map<Integer,List<Integer>> graph = new HashMap();
        int n=quiet.length;
        int[] visited = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
         //construct graph, add bidirectional vertex
        for(int[] edge : edges){
           graph.get(edge[1]).add(edge[0]);
          
        }
      
        int []ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i+=1){
            dfs(graph,ans,i,quiet);
         
        }
		return ans;
       
        
       
    }
}