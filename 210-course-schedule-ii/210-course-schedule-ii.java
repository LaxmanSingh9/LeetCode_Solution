class Solution {
    public int[] getArrFromStack(Stack<Integer>st){
        int []ansArr=new int[st.size()];
        int idx=0;
        while(!st.empty()){
            int top=st.peek();
            st.pop();
            ansArr[idx++]=top;
        }
        return ansArr;
    }
    public boolean doesContainsCycle(ArrayList<ArrayList<Integer>>adjList,int[]recSt,int u,Stack<Integer>st){ 
        if(recSt[u]!=0)
            return recSt[u]==1;
        recSt[u]=1;
        for(int v:adjList.get(u)){
            if(recSt[v]==0 &&  doesContainsCycle(adjList,recSt,v,st))
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
        int recSt[]=new int[numCourses];
        Stack<Integer>preqStack=new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(doesContainsCycle(adjList,recSt,i,preqStack))
                return new int[0];
        }
        return getArrFromStack(preqStack);
        
       
    }
}