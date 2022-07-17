class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,cnt=0,ans=0,n=nums.length;
        for(int j=0;j<n;j+=1){
            if(nums[j]==0){
              cnt+=1;    
            }
            if(cnt==2){
               while(cnt>1){
                 cnt-=nums[i]==0?1:0;
                 i+=1;
                }
            }
            ans=Math.max(ans,j-i);
        }
        return ans;
    }
}