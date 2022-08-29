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
        int []vis=new int[n];
        UnionFind uf=new UnionFind(26);
        for(int i=0;i<n;i++){
            if(arr[i].charAt(1)=='='){
              int a=arr[i].charAt(0),b=arr[i].charAt(3);
              //System.out.println(a-97+" "+b-97);
              uf.union(a-97,b-97);
              vis[i]=1;
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0){
               int a=arr[i].charAt(0),b=arr[i].charAt(3);
            //  System.out.println(a-97+" "+b-97); 
               if(uf.isConnected(a-97,b-97))
                   return false;
               
            }
        }
        return true;   
    }
}