class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
 
        Stack<Integer>list=new Stack<>();
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
        int idx=0;
        while(list.isEmpty()==false){
            ans[idx]=list.pop();
            idx+=1;
        }
        return n==0?ans:new int[0];
        
    }
}