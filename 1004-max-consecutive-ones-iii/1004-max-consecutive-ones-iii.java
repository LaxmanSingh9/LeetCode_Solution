class Solution {
    public int longestOnes(int[] nums, int k){
       int[]cnt=new int[2]; 
       int lgOneSubArr=0,st=0;
       for(int end=0;end<nums.length;end++){
           cnt[nums[end]]++;
           while(cnt[0]>k){
            cnt[nums[st]]--;st++;
           } 
           lgOneSubArr=Math.max(lgOneSubArr,end-st+1);
       } 
       return lgOneSubArr; 
    }
}