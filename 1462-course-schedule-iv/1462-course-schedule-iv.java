class Solution {
    //dfs to check query validation
    public List<Boolean> checkDependcies(int[][]queries,Map<Integer,Set<Integer>>prerequisitesMap){
        int qlen=queries.length;List<Boolean>ans=new ArrayList<>();
        for(int i=0;i<qlen;i+=1){
            int d=queries[i][0];int dep=queries[i][1];
            Set<Integer> set = prerequisitesMap.get(dep);
            if(set.contains(d)){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
            
        }
        return ans;
        
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n=numCourses;
        Map<Integer,List<Integer>> graph = new HashMap();
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<>(); 
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
              prerequisitesMap.put(i, new HashSet<>());
        }
        int []inDeg=new int[n];
        for(int edges[]:prerequisites){
            graph.get(edges[0]).add(edges[1]);
            inDeg[edges[1]]+=1;
        }
        
        //Topologival Sort
       
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i+=1){
            if(inDeg[i]==0)
               q.add(i);
        }
        while(q.isEmpty()==false){
            int v=q.poll();
           // System.out.println(v);
            for(int e:graph.get(v)){
                prerequisitesMap.get(e).add(v);
                prerequisitesMap.get(e).addAll(prerequisitesMap.get(v));
               if(--inDeg[e]==0)
                  q.add(e);
            }
        }
        //Topological Sort End
        return checkDependcies(queries,prerequisitesMap);
      
       
        
        
        
        
        
        
        
        
    }
}