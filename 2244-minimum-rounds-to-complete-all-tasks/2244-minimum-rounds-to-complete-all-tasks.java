class Solution {
  public int solve(int n,int []dp){
      if(n<=3){
          return n<=1?-1:1;
      }
      if(dp[n]!=0)
          return dp[n];
      int ans1=solve(n-2,dp);
      int ans2=solve(n-3,dp);
      if(ans1<=-1 && ans2<=-1) 
        dp[n]=-1;
      else
        dp[n]=1+(Math.min(ans1,ans2)==-1?Math.max(ans1,ans2):Math.min(ans1,ans2));
      return dp[n];
  } 
  public int minimumRounds(int[] tasks) {
      Map<Integer,Integer>map=new HashMap<>();
      int ans=0,round=0;
      int []dp=new int [tasks.length+3];
      for(int val:tasks){
          if(map.containsKey(val))
             map.put(val,map.get(val)+1);
          else
             map.put(val,1);
      }
      for (Map.Entry<Integer,Integer> entry : map.entrySet()){
          round=solve(entry.getValue(),dp);
          if(round==-1)return -1;
          else ans+=round;
      }
      return ans;
  
   }
}