class Solution {
    public int minSetSize(int[] arr) {
     int n=arr.length,ans=0; 
     Map<Integer,Integer>map=new HashMap<>();
     for(int val:arr)
        map.put(val,map.getOrDefault(val,0)+1);
     
     List<Integer>freq=new ArrayList<>();
     for(int val:map.values())
         freq.add(val);
     Collections.sort(freq,Collections.reverseOrder()) ;
     int removed=0;
     for(int val:freq){
        if(removed>=n/2)
          break;
        removed+=val;
        ans+=1; 
     }
     return ans;   
     //take an map to store all the occuracne
     //sort the map
     //add until we remove n/2 elements
        
    }
}