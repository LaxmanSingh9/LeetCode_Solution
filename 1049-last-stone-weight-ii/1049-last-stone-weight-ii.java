class Solution {
    public int solve(int[]arr,int target){
         int n=arr.length;
         int [][]dp=new int[n+1][target+1];
         for(int i=1;i<target+1;i++)
             dp[0][i]=0;
         for(int i=1;i<n+1;i++)
             dp[i][0]=0;
         for(int i=1;i<n+1;i++){
            for(int j=1;j<target+1;j++){
               if(j>=arr[i-1]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-arr[i-1]]+arr[i-1]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            } 
         }
         return dp[n][target];                                            
    }
    public int lastStoneWeightII(int[] stones) {
        int stoneSum=0,n=stones.length;
        for(int val:stones)
            stoneSum+=val;
        int target=stoneSum/2;
        int [][]memo=new int[n+1][target+1];
        for(int []ar:memo)
            Arrays.fill(ar,-1);
        int sumObtain= solve(stones,target);
        return stoneSum-2*sumObtain;
    }
}