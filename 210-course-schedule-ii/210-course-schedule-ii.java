class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i+=1)
            adjList.add(new ArrayList<>());
        int[]inorder=new int[numCourses];
        for(int []pre:prerequisites){
            inorder[pre[0]]+=1;
            adjList.get(pre[1]).add(pre[0]);
        }
        Queue<Integer>queue=new LinkedList<>();
        List<Integer>ans=new ArrayList<>();
        for(int v=0;v<numCourses;v++){
            if(inorder[v]==0){
                ans.add(v);
                queue.add(v);
            }
        }
        while(!queue.isEmpty()){
            int u=queue.poll();
            for(int v:adjList.get(u)){
                --inorder[v];
                if(inorder[v]==0){
                   ans.add(v);
                   queue.add(v);
                }
            }
        }
        int []ansArr=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            ansArr[i]=ans.get(i);
        return ans.size()!=numCourses?new int[0]:ansArr;
    }
}