class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        Map<Integer,List<Integer>> graph = new HashMap();
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList());
        }
        int []inDeg=new int[n];
        for(int edges[]:prerequisites){
            graph.get(edges[1]).add(edges[0]);
            inDeg[edges[0]]+=1;
        }
        
        //Topologival Sort
       
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i+=1){
            if(inDeg[i]==0)
               q.add(i);
        }
 
        List<Integer>list=new ArrayList<>();
        while(q.isEmpty()==false){
            int v=q.poll();
            list.add(v);
            n-=1;
            for(int e:graph.get(v)){
                if(--inDeg[e]==0){
                 q.add(e);
                }
                 
            }
        }
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i+=1){
            ans[i]=list.get(i).intValue();
        }
        return n==0?ans:new int[0];
        
    }
}