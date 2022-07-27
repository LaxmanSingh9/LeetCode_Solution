/*
   A given number can include  only in a subset
   All the numbers are non-negative ,there are some minor changes in case of negative numbers
   
   Backtracing 
   we are making all the placements for k subsets with sum/k target
  Sorting reduces some unnesary computations by not going deeper stack call
   
   
   
   
*/
class Solution {
    public int getSumOfArr(int []arr){
        int ans=0;
        for(int val:arr)ans+=val;
        return ans;
    }
    public boolean solve(int []nums,int end,int target ,int curr ,int k,boolean[] vis){
        if(k==1 || curr>target) //finds k-1 subset sum , will surely get the rest subset sum
            return k==1?true:false;
        if(curr==target)
            return solve(nums,nums.length-1,target,0,k-1,vis); //Making further calls for  k-1  subsets & 
        for(int i=end;i>=0;i-=1){
            if(vis[i]==false){
                vis[i]=true;
                if(solve(nums,i-1,target,curr+nums[i],k,vis))
                  return true;  
                vis[i]=false; // Uncheck indexs with does not give target sums
             }
         }
         return false; //in the end return false , can not find placements of number for k subsets
        
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =getSumOfArr(nums);
        if(k <= 0 || sum%k != 0)return false;
        boolean []vis=new boolean[nums.length];
        Arrays.sort(nums);  //
        return solve(nums,nums.length-1,sum/k,0,k,vis);
        
    }
}