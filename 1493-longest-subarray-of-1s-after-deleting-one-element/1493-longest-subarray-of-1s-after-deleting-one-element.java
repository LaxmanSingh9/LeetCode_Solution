class Solution {
    public int longestSubarray(int[] nums) {
      int []cnt=new int[nums.length];
      int st=0,res=0;
      for(int end=0;end<nums.length;end++){
         cnt[nums[end]]++; 
         while(cnt[0]>1){cnt[nums[st]]--;st++;}
         res=Math.max(res,end-st+1); 
      }
      return res-1;  
    }
}