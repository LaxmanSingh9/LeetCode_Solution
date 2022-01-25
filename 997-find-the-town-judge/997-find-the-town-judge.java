class Solution {
    public int findJudge(int n, int[][] trust) {
        int[]inDegree=new int[n+1];
        for(int[]arr:trust){
            inDegree[arr[0]]-=1;//For outdegree
            inDegree[arr[1]]+=1;//For indegree
        }
        for(int edge=1;edge<inDegree.length;edge+=1){
           if(inDegree[edge]==n-1){
                return edge;      //if indrgree equals n-1
            }
        }
        return -1;
    }
}