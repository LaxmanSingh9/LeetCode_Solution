class Solution {
    public int solve(int[]arr,int idx,int target,int[][]memo){
        if(target<=0 || idx>=arr.length)
            return target<0?Integer.MAX_VALUE:target;
        if(memo[idx][target]!=-1)
            return memo[idx][target];
        int inclde=Integer.MAX_VALUE,skip=Integer.MAX_VALUE;
        if(arr[idx]<=target)
            inclde=solve(arr,idx+1,target-arr[idx],memo);
        skip=solve(arr,idx+1,target,memo);
        memo[idx][target]=Math.min(inclde,skip); 
        return memo[idx][target];
        
    }
    public int lastStoneWeightII(int[] stones) {
        int stoneSum=0,n=stones.length;
        for(int val:stones)
            stoneSum+=val;
        int target=stoneSum/2;
        int [][]memo=new int[n+1][target+1];
        for(int []ar:memo)
            Arrays.fill(ar,-1);
        int ans=solve(stones,0,target,memo);
        return 2*ans+stoneSum%2;
    }
}