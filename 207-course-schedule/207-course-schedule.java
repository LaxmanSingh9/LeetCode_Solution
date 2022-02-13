class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
 
  
        while(q.isEmpty()==false){
            int v=q.poll();
            n-=1;
            for(int e:graph.get(v)){
                
                if(--inDeg[e]==0)
                  q.add(e);
            }
        }
        return n==0?true:false;
        
    }
}