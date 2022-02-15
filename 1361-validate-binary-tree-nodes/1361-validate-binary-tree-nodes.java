class Solution {
    public boolean dfs(int n,int[] leftChild, int[] rightChild,int s ,int []vis){
        if(s==-1){
            return true;
        }
        if(vis[s]==1){
            return false;
        }
        vis[s]=1;
        return dfs(n,leftChild,rightChild,rightChild[s],vis)&& dfs(n,leftChild,rightChild,leftChild[s],vis);
    }
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
          int []vis=new int[n];
           int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1 && inDegree[leftChild[i]]++ == 1) return false; // inDegree can't be exceed to 1
            if (rightChild[i] != -1 && inDegree[rightChild[i]]++ == 1) return false; // inDegree can't be exceed to 1
        }
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root != -1) return false; // Multiple root
                root = i;
            }
        }
        int[] visited = new int[n];
        boolean ans=root != -1 && dfs(n,leftChild, rightChild,root,visited);
        boolean k=IntStream.of(visited).anyMatch(x -> x ==0);
        if(k==true){
         return false;   
        }
        return ans;
               
        
        
    }
}