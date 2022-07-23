class Solution {
  public int[] solve(int []dp){
     dp[0]=1;dp[1]=-1;dp[2]=1;dp[3]=1;dp[4]=2;dp[5]=2;
     for(int i=6;i<dp.length;i+=1){
         dp[i]=1+Math.min(dp[i-2],dp[i-3]);
     }
     return dp;
  } 
  public int minimumRounds(int[] tasks) {
      int []dp=new int[100015];
      Map<Integer,Integer>map=new HashMap<>();
      for(int val:tasks){
          if(map.containsKey(val))
             map.put(val,map.get(val)+1);
          else
             map.put(val,1);
      }
      int ans=0,n;dp=solve(dp);
      for (Map.Entry<Integer,Integer> entry : map.entrySet()){
          n=entry.getValue();
          if(dp[n]==-1){
              return -1;
          }
          ans+=dp[n];
      }
      return ans;
  
   }
}