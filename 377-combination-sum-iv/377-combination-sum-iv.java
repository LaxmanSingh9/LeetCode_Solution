class Solution {
    public int totalWaysSumUptoTarget(int []nums,int target,int idx,int[][]memo){
        if(target==0 || target<0 || idx>=nums.length)
          return  target==0?1:0;
        if(memo[idx][target]!=-1)
            return memo[idx][target];
        int incl=0,excl=0;
        incl=totalWaysSumUptoTarget(nums,target-nums[idx],0,memo);
        excl=totalWaysSumUptoTarget(nums,target,idx+1,memo);
        return  memo[idx][target]=incl+excl;
    }
    public int combinationSum4(int[] nums, int target) {    
        int [][]memo=new int[nums.length+1][target+1];
        for(int []ar:memo)
            Arrays.fill(ar,-1);
        return totalWaysSumUptoTarget(nums,target,0,memo);
    }
}