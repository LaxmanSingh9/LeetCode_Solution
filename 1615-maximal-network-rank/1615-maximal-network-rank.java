class Solution {
    public int maximalNetworkRank(int n, int[][] edges) {
        int [][]matrix=new int[n][n];
        int[] count = new int[n];
        for(int[] edge : edges){
           count[edge[0]]+=1;
           count[edge[1]]+=1;
           matrix[edge[0]][edge[1]]=1;
           matrix[edge[1]][edge[0]]=1;
        }
        int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i+=1){
            for(int j=i+1;j<n;j+=1){
                int totalEdgesBtwTwoVertices=count[i]+count[j]-(matrix[i][j]==1?1:0);
                ans=Math.max(totalEdgesBtwTwoVertices,ans);
            }
        }
        return ans;
    }
}