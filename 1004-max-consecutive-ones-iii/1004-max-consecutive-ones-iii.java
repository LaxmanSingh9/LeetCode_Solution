class Solution {
    public int longestOnes(int[] nums, int k){
       int[]cnt=new int[2]; 
       int lgOneSubArr=0,st=0,end;
       for(end=0;end<nums.length;end++){
         if (nums[end] == 0) k--;
         if (k < 0 && nums[st++] == 0) k++;
           //lgOneSubArr=Math.max(lgOneSubArr,);
       } 
       return end-st; 
    }
}