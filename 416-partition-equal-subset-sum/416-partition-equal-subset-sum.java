class Solution {
    public int calSumOfArr(int []ar){
        int ans=0;
        for(int val:ar)
            ans+=val;
        return ans;
    }
    public int  solve(int arr[],int i,int target,int [][]memo){
        if(target==0 || i>=arr.length)
            return target==0?1:0;
        if(memo[i][target]!=-1){
            return memo[i][target];
        }
        int consist=0;
        if(arr[i]<=target)
          consist=solve(arr,i+1,target-arr[i],memo);
        if(consist==1){
             memo[i][target]=1;
            return 1;
         }
         int skip=solve(arr,i+1,target,memo);
        memo[i][target]= consist==1?consist:skip;
        return memo[i][target];
        
        
    }
    public boolean canPartition(int[] nums) {
        int sumOfArr=calSumOfArr(nums);
        if(sumOfArr%2==1)
            return false;
        int [][]memo=new int[nums.length+1][sumOfArr/2+2];
        for(int []ar:memo)Arrays.fill(ar,-1);
        return solve(nums,0,sumOfArr/2,memo)==1?true:false;
    }
}