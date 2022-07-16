class Solution {
    public int longestSubarray(int[] nums) {
        int i=0,j=0,prev=0,ans=0,sum=0,n=nums.length;
        while(i<n && j<n){
            sum=0;
            while(j<n && nums[j]==1) {
                sum+=nums[j];
                if(j-i+1!=sum && j-i+1!=sum+1)break;
                j+=1;
            }
            ans=Math.max(ans,sum+prev);prev=sum;i=j;j+=1;
            
        }
        return ans==n?ans-1:ans;
    }
}