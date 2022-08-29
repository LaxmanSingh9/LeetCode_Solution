class UnionFind {
    private int count;
    private int[] parent,rank;
    public UnionFind(int n) {
      parent = new int[n];
      rank = new int[n];
      count=n;
      for(int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }
    public void union(int x, int y) {
      int rootX = find(x);
      int rootY = find(y);
      
      if(rootX != rootY) {
        if(rank[rootX] > rank[rootY]) {
          rank[rootX]++;
          parent[rootY] = rootX;
        } else {
          rank[rootY]++;
          parent[rootX] = rootY;
        }
        count--;
      }
    }
    
    public int find(int x) {
      if(parent[x] == x) return x;
      
      int root = find(parent[x]);
      parent[x] = root; //path compression
      return root;
    }
    
    public boolean isConnected(int x, int y) {
      return find(x) == find(y);
    }
    public int getCount(){
        return count;
    }
 }


class Solution {
    //To connected n nodes , we al least need n-1 unique edges
    //if there are n-1 edges then minimum opeation will be total disconnected componets in graph
    public void dfs(ArrayList<ArrayList<Integer>>adjList,boolean []vis,int u){
        vis[u]=true;
        for(int v:adjList.get(u)){
            if(!vis[v])
                dfs(adjList,vis,v);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int totalConnections=connections.length;
        if(totalConnections<n-1)//Most important , there are less then n-1 edges then we can not make connect a graph
            return -1;
        UnionFind uf=new UnionFind(n);
        for(int []con:connections)
            uf.union(con[0],con[1]);
        return uf.getCount()-1; //TotalDisconnectedComponents-1
    }
}