class Solution {
    public void dfs(int[][]graph,int node,List<List<Integer>>res,List<Integer>path){
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfs(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }

        
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer>path=new ArrayList<>();
        path.add(0);
        List<List<Integer>>ans=new ArrayList<>();
        dfs(graph,0,ans,path);
        return ans;
    }
}