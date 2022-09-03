class Solution {
    public boolean canFindTargetSum(int []nums,int target,int i,int[][]memo){
          if(target<=0 || i>=nums.length)
              return target==0;
          boolean include=false,skip=false;
          if(memo[i][target]!=0)
              return memo[i][target]==1;
          if(nums[i]<=target)
              include=canFindTargetSum(nums,target-nums[i],i+1,memo);
          if(include)
              return true;
          skip=canFindTargetSum(nums,target,i+1,memo);
          memo[i][target]=(include || skip)?1:2;
          return include || skip;
          
    }
    public boolean canPartition(int[] nums) {
        int sumArr=0;
        for(int val:nums)
            sumArr+=val;
        if(sumArr%2==1)
            return false;
        int target=sumArr/2;
        int [][]memo=new int[nums.length+1][target+1];
        return canFindTargetSum(nums,target,0,memo);
        
    }
}