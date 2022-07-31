class Solution {
    int ans=Integer.MAX_VALUE;
    public int solve(int []arr,int i,int target,int curr,int[][]memo){
        if(i>=arr.length){
           return target;
        }
        if(memo[i][target]!=-1)
            return memo[i][target];
        int skip=Integer.MAX_VALUE,add=Integer.MAX_VALUE;
        if(arr[i]<=target){
             add=solve(arr,i+1,target-arr[i],curr+arr[i],memo);
        }
        skip=solve(arr,i+1,target,curr,memo);
        memo[i][target]=Math.min(add,skip);
        return  memo[i][target];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int val:stones)sum+=val;
        int [][]memo=new int[stones.length+1][sum/2+1];
        for(int []ar:memo)Arrays.fill(ar,-1);
        int target=(sum>>1);
        return sum-2 *(target-solve(stones,0,target,0,memo)) ;
    }
}