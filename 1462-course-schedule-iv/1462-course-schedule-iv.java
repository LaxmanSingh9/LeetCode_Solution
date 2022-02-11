class Solution {
    //dfs to check query validation
    public boolean checkDependcies(List<List<Integer>>lookUpArray,int d,int dep){
         if(lookUpArray.get(d).contains(dep)){
             return true;
         }
         for(int e:lookUpArray.get(d)){
             if(checkDependcies(lookUpArray,e,dep)){
                 return true;
             }
             
         }
         return false;
        
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
        List<List<Integer>>lookUpArray=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            lookUpArray.add(new ArrayList<>());
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
        
        //Logic To Check Query Validation
       
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
}