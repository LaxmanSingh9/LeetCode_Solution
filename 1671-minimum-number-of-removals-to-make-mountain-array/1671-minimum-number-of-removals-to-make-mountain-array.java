class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length,ans=1;
        int []pref=new int[n];int []suff=new int[n];
        Arrays.fill(pref,1);Arrays.fill(suff,1);
        for(int i=1;i<n;i+=1){
          for(int j=i-1;j>=0;j-=1){
              if(nums[i]>nums[j])
                pref[i]=Math.max(pref[i],pref[j]+1);
          }
        }
        for(int i=n-1;i>=0;i-=1){
          for(int j=i+1;j<n;j+=1){
              if(nums[i]>nums[j])
                  suff[i]=Math.max(suff[i],suff[j]+1);
          } 
        }
        for(int i=1;i<n-1;i+=1){
           if(pref[i]>1 &&suff[i]>1) //both atleast should be greater than one 
             ans=Math.max(pref[i]+suff[i]-1,ans);
        }
        return nums.length-ans;
    }
}