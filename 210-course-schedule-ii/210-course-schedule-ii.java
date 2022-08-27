class Solution {
    public boolean doesContainsCycle(ArrayList<ArrayList<Integer>>adjList,boolean[]vis,int[]recSt,int u,Stack<Integer>st){
        vis[u]=true;
        recSt[u]=1;
        for(int v:adjList.get(u)){
            if(!vis[v] &&  doesContainsCycle(adjList,vis,recSt,v,st))
                return true;
            else if(recSt[v]==1)
                return true;
            
        }
        recSt[u]=2;
        st.push(u);
        return false;
    
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i+=1)
            adjList.add(new ArrayList<>());
        for(int []pre:prerequisites)
            adjList.get(pre[1]).add(pre[0]);
        boolean vis[]=new boolean[numCourses];
        int recSt[]=new int[numCourses];
        Stack<Integer>preqStack=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(!vis[i] && doesContainsCycle(adjList,vis,recSt,i,preqStack))
                return new int[0];
            else if(vis[i] && recSt[i]==1)
                return new int[0];
        }
        int []ansArr=new int[preqStack.size()];
        int idx=0;
        while(!preqStack.empty()){
            int top=preqStack.peek();
            preqStack.pop();
            ansArr[idx++]=top;
        }
        return ansArr;
        
       
    }
}