class Solution {
  public int minimumRounds(int[] tasks) {
      int []dp=new int[100010];
      dp[0]=1;dp[1]=-1;dp[2]=1;dp[3]=1;dp[4]=2;
      for(int i=5;i<=tasks.length;i+=1){
         dp[i]=1+Math.min(dp[i-2],dp[i-3]);
      }
      Map<Integer,Integer>map=new HashMap<>();
      for(int val:tasks)
         map.put(val,map.getOrDefault(val,0)+1);
      
      int ans=0;
      for (Map.Entry<Integer,Integer> entry : map.entrySet()){
          int n=entry.getValue();
          if(n==1)return -1;
          ans+=dp[n];
      }
      return ans;
  
   }
}