class Solution {
    public int totalArrSum(int []arr){
       int sum=0;
       for(int val:arr)
          sum+=val; 
       return sum;
    }
    public int solve(int []arr,int target,int idx){
       if(idx>=arr.length)
          return target==0?1:0; 
       //append minus sign
       int incl=0,excl=0; 
       incl=solve(arr,target-arr[idx],idx+1);
       //append plus sign 
       excl=solve(arr,target,idx+1); 
       return  incl+excl;
        
    }
    public int findTargetSumWays(int[] nums, int target) {
      int sum=totalArrSum(nums);
      if((target+sum)%2!=0 || Math.abs(target)>sum)return 0;
      target=(sum+target)/2;
      return solve(nums,target,0);    
    }
}