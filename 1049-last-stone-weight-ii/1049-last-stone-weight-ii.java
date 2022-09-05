class Solution {
    public int solve(int[]arr,int target){
         int n=arr.length;
         int []dp=new int[target+1];
         for(int val:arr){
            for(int i=target;i>=val;i--){
               dp[i]=Math.max(dp[i],dp[i-val]+val);
            } 
         }
         return dp[target];                                            
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