class Solution {
    public int solve(int []cost,int index,int []ans){
        if(index<=-1){
            return 0;
        }
        if(ans[index]!=-1){
            return ans[index];
        }
        ans[index]=Math.min(solve(cost,index-1,ans),solve(cost,index-2,ans))+cost[index];
        return ans[index];
        
    }
    public int minCostClimbingStairs(int[] cost) {
        int index=cost.length;
        int ans[]=new int[index+1];
        Arrays.fill(ans,-1);
        return  Math.min(solve(cost,index-1,ans),solve(cost,index-2,ans));
    }
}