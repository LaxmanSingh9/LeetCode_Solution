class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer>map=new HashMap<>();
        int len=0;
        for(int[]arr:edges){
            int s=arr[0];
            int e=arr[1];
            map.put(s,1+map.getOrDefault(s,0));
            map.put(e,1+map.getOrDefault(e,0));
            len+=1;
            if(map.get(s)==len && len>1){
                return s;
            }
            if(map.get(e)==len &&len>1){
                return e;
            }
        }
        return -1;
        
    }
}