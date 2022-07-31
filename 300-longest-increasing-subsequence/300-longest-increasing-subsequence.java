class Solution {
    public int solve(int []nums,int i,int prev,int [][]memo){
        if(i>=nums.length)
            return 0; 
        if(prev!=-1 && memo[i][prev]!=-1)
            return memo[i][prev];
        int add=0,skip=0;
        if(prev==-1 || nums[prev]<nums[i])
          add=solve(nums,i+1,i,memo)+1;
        skip=solve(nums,i+1,prev,memo);
        if(prev!=-1)
           memo[i][prev]=Math.max(add,skip);
        return Math.max(add,skip);
    
    }
    public int lengthOfLIS(int[] nums) {
        int [][]memo=new int[nums.length+1][nums.length+1];
        for(int []ar:memo)
           Arrays.fill(ar,-1);
        return solve(nums,0,-1,memo);
    }
}