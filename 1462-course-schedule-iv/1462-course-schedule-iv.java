class Solution {
    //dfs to check query validation
    public boolean checkDependcies(List<Set<Integer>>lookUpArray,int d,int dep){
         if(lookUpArray.get(dep).contains(d)){
             return true;
         }
         return false;
        
    }
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n=numCourses;
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
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
        List<Set<Integer>>lookUpArray=new ArrayList<>();
        for(int i=0;i<n;i+=1){
            lookUpArray.add(new HashSet<>());
        }
        while(q.isEmpty()==false){
            int v=q.poll();
           // System.out.println(v);
            for(int e:graph.get(v)){
                lookUpArray.get(e).add(v);
                lookUpArray.get(e).addAll( lookUpArray.get(v));
                if(--inDeg[e]==0)
                  q.add(e);
            }
        }
        //Topological Sort End
        
        //Logic To Check Query Validation
       
        int qlen=queries.length;List<Boolean>ans=new ArrayList<>();
        for(int i=0;i<qlen;i+=1){
            if(checkDependcies(lookUpArray,queries[i][0],queries[i][1])){
                ans.add(true);}
            else{
                ans.add(false);}
            
        }
        return ans;
        
        
        
        
        
        
        
    }
}