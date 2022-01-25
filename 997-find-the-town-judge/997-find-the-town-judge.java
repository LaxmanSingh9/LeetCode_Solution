class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 &&n==1){
            return 1;
        }
        Map<Integer,List<Integer>> map = new HashMap();
        int[] visited = new int[n];
        
        for(int i = 0 ; i < n+1 ; i++){
            map.put(i, new ArrayList());
        }
         //construct graph, add bidirectional vertex
        for(int[] edge : trust){
           map.get(edge[1]).add(edge[0]);
           
        }
        int ans=-1;
        for(Map.Entry<Integer,List<Integer>>m:map.entrySet()){
            if(m.getValue().size()==n-1){
                if(ans!=-1){
                    return -1;
                }
                ans=m.getKey();
                
            }
        }
        if(ans==-1){
            return -1;
        }
        for(int arr[]:trust){
            if(ans==arr[0]){
                return -1;
            }
        }
        return ans;
    }
}