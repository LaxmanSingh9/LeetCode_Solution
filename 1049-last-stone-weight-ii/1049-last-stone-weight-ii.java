class Solution {
    int ans=Integer.MAX_VALUE;
    public int solve(int []arr,int i,int target,int sum,int[][]memo){
        if(i>=arr.length){
           return sum-2*target;
        }
        if(memo[i][target]!=-1)
            return memo[i][target];
        int skip=Integer.MAX_VALUE,add=Integer.MAX_VALUE;
        if(2*(target+arr[i])<=sum){
             add=solve(arr,i+1,target+arr[i],sum,memo);
        }
        skip=solve(arr,i+1,target,sum,memo);
        memo[i][target]=Math.min(add,skip);
        return  memo[i][target];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int val:stones)sum+=val;
        int [][]memo=new int[stones.length+1][sum+1];
        for(int []ar:memo)Arrays.fill(ar,-1);
        return solve(stones,0,0,sum,memo);
    }
}