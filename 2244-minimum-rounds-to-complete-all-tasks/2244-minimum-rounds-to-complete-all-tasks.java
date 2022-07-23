class Solution {
  public int minimumRounds(int[] tasks) {
      Map<Integer,Integer>map=new HashMap<>();
      for(int val:tasks)
         map.put(val,map.getOrDefault(val,0)+1);
      int ans=0;
      for (Map.Entry<Integer,Integer> entry : map.entrySet()){
          int n=entry.getValue();
          if(n==1)return -1;
          else ans+=n/3+(n%3==0?0:1);
      }
      return ans;
  
   }
}