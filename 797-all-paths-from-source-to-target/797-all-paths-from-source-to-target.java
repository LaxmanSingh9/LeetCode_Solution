class Solution {
    public void dfs(int s,int e,int[][]graph,List<Integer>path,List<List<Integer>>ans){
        if(s==e){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int child:graph[s]){
            path.add(child);
            dfs(child,e,graph,path,ans);
             path.remove(path.size()-1);
            
        }
        
        
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>path=new ArrayList<>();
        path.add(0);
        List<List<Integer>>ans=new ArrayList<>();
        dfs(0,graph.length-1,graph,path,ans);
        return ans;
    }
}