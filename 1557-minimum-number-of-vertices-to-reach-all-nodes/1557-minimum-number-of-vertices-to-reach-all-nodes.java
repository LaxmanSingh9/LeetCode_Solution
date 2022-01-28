class Solution {
    //For an diretd acyclic graph the nodes with no in-degree must be in solution
    //Since those vertices are starting point of DAG.
    
    public void dfs(Map<Integer,List<Integer>>graph,int[] visited,int s,Map<Integer,Integer>map){
        visited[s]=1;
        for(int edge:graph.get(s)){
            if(visited[edge]!=1){
                dfs(graph,visited,edge,map);
            }
            else{
                if(map.getOrDefault(edge,-1)!=-1){
                    map.put(edge,-2);
                }
            }
        }
        
        
        
    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
         Map<Integer,Integer>map=new HashMap<>();
         Map<Integer,List<Integer>>graph=new HashMap<>();
         for(int i=0;i<n;i+=1){
             graph.put(i,new ArrayList<>());
         }
         for(List<Integer>edgeArr:edges){
             graph.get(edgeArr.get(0)).add(edgeArr.get(1));
            
         }
         int []visited=new int[n];
         for(int i=0;i<n;i+=1){
             if(visited[i]!=1){
                 dfs(graph,visited,i,map);
                 map.put(i,1);
             }
         }
         List<Integer>answer=new ArrayList<>();
         for(Map.Entry<Integer,Integer>m:map.entrySet()){
             if(m.getValue()==1){
                 answer.add(m.getKey());
             }
         }
         return answer;
    }
}