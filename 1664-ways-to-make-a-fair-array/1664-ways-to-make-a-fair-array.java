class Solution {
    public int waysToMakeFair(int[] nums) {
        int ans=0, n=nums.length, right[]=new int[2], left[]=new int[2];
        for(int i=0;i<n;i+=1){
             right[i%2]+=nums[i];
        }
        for(int i=0;i<n;i+=1){
             right[i%2]-=nums[i];
             if(left[0]+right[1]==left[1]+right[0])
                 ans+=1;   
             left[i%2]+=nums[i];
        }
        return ans;
        
    }
}