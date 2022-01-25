class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int[]arr:edges){
            int s=arr[0];
            int e=arr[1];
            map.put(s,1+map.getOrDefault(s,0));
            map.put(e,1+map.getOrDefault(e,0));
        }
        int ans=0;
        int prevfreq=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
           int value=entry.getKey();
           int freq=entry.getValue();
           if(freq>prevfreq){
               ans=value;
               prevfreq=freq;
           }
        }
        return ans;
        
    }
}