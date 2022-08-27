class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {        
        int []incomingEdges=new int[n];
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int []pre:prerequisites){
            incomingEdges[pre[1]]++;
            adj.get(pre[0]).add(pre[1]);
        }
        Queue<Integer>queue=new LinkedList<>();
        for(int v=0;v<n;v+=1){
            if(incomingEdges[v]==0)
                queue.add(v);
        }
       
        while(!queue.isEmpty()){
            int u=queue.poll();
            for(int v:adj.get(u)){
                if(--incomingEdges[v]==0){
                    queue.add(v);
                }
            }
            n-=1;
        }
        return n==0;
     }
}