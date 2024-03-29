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
    public boolean equationsPossible(String[]  arr) {
        int n=arr.length;
        UnionFind uf=new UnionFind(26);
        for(int i=0;i<n;i++){
            if(arr[i].charAt(1)=='=')
              uf.union(arr[i].charAt(0)-'a',arr[i].charAt(3)-'a');
        }
        for(int i=0;i<n;i++){
            if(arr[i].charAt(1)=='!' && (uf.isConnected(arr[i].charAt(0)-'a',arr[i].charAt(3)-'a')))
              return false;
        }
        return true;   
    }
}