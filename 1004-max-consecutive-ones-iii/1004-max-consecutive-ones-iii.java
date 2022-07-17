class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0,zeroCount=0,i=0,n=nums.length;
        for(int j=0;j<n;j+=1){
           if(nums[j]==0)zeroCount+=1;
           while(zeroCount>k){
              if(nums[i]==0)
                  zeroCount-=1;
              i+=1;
           }
           ans=Math.max(ans,j-i+1);
        }
          return ans;  
    }
      
}

