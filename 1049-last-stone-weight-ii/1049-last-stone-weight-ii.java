class Solution {
    int ans=Integer.MAX_VALUE;
    public int solve(int []arr,int i,int target,int curr,int[][]memo){
        if(i>=arr.length){
           return curr;
        }
        if(memo[i][curr]!=-1)
            return memo[i][curr];
        int skip=Integer.MIN_VALUE,add=Integer.MIN_VALUE;
        if(curr+arr[i]<=target){
             add=solve(arr,i+1,target,curr+arr[i],memo);
        }
        skip=solve(arr,i+1,target,curr,memo);
        memo[i][curr]=Math.max(add,skip);
        return  memo[i][curr];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int val:stones)sum+=val;
        int [][]memo=new int[stones.length+1][sum/2+1];
        for(int []ar:memo)Arrays.fill(ar,-1);
         int target=(sum>>1);
        return sum-2*solve(stones,0,target,0,memo);
    }
}