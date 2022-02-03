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
    public List<Integer> eventualSafeNodes(int[][] edges) {
        int n=edges.length;
        List<Integer>ans=new ArrayList<>();int []inDeg=new int[n];
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList());
        }
        for(int i=0;i<n;i+=1){
            for(int edge:edges[i]){
                graph.get(edge).add(i);
                inDeg[i]+=1;
            }
              
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i+=1){
            if(inDeg[i]==0)
                q.add(i);
        }
        while(!q.isEmpty()){
            int s=q.poll();
            ans.add(s);
            for(int edge:graph.get(s)){
                inDeg[edge]-=1;
                if(inDeg[edge]==0){
                    q.add(edge);
                }
            }
            
       }
       Collections.sort(ans);
       return ans;
    }

}