class Solution {
    //For an diretd acyclic graph the nodes with no in-degree must be in solution
    //Since those vertices are starting point of DAG.
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         int []inDegrees=new int[n];//Array to store indegree of vertices
         for(List<Integer> edge:edges){
             inDegrees[edge.get(1)]+=1;   
         }
         
         List<Integer>answer=new ArrayList<>();
         for(int idx=0;idx<n;idx+=1){
             if(inDegrees[idx]==0)
               answer.add(idx);  //store  vertices with zero indegree
         }
         return answer;
    }
}