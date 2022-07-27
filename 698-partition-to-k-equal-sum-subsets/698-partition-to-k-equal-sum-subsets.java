import java.util.*;
class Solution {
    public int getSumOfArr(int []arr){
        int ans=0;
        for(int val:arr)ans+=val;
        return ans;
    }
    public boolean solve(int []nums,int end,int target ,int curr ,int k,boolean[] vis){
        if(k==1 || curr>target) //finds k-1 subset sum , will surely get the rest sum
            return k==1?true:false;
        if(curr==target)
            return solve(nums,nums.length-1,target,0,k-1,vis);
        for(int i=end;i>=0;i-=1){
            if(vis[i]==false){
                vis[i]=true;
                if(solve(nums,i-1,target,curr+nums[i],k,vis))
                  return true;  
                vis[i]=false;
             }
         }
         return false;
        
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =getSumOfArr(nums);
        if(k <= 0 || sum%k != 0)return false;
        boolean []vis=new boolean[nums.length];
        Arrays.sort(nums);
        return solve(nums,nums.length-1,sum/k,0,k,vis);
        
    }
}