class Solution {
  public int minimumRounds(int[] tasks) {
      Map<Integer,Integer>freq=new HashMap<>();
      for(int val:tasks)
         freq.put(val,freq.getOrDefault(val,0)+1);
      int ans=0;
      for(int n:freq.values()) {
          if(n==1)return -1;
          else ans+=n/3+(n%3==0?0:1);
      }
      return ans;
  
   }
}