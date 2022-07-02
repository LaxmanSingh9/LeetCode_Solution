class Solution {
    public int waysToMakeFair(int[] nums) {
        int ans=0,n=nums.length;
        int oddSum=0,evenSum=0;
        for(int i=0;i<n;i+=1){
            if(i%2==0)
               evenSum+=nums[i];
            else
               oddSum+=nums[i];
        }
        int evenSumUpto=0,oddSumUpto=0,currEven=0,currOdd=0;
        
        for(int i=0;i<n;i+=1){
             currEven=i%2==0?nums[i]:0;
             currOdd=i%2==1?nums[i]:0;
             if(evenSumUpto+(oddSum-currOdd-oddSumUpto)==oddSumUpto+(evenSum-currEven-evenSumUpto)){
                   ans+=1;   
             }
             evenSumUpto=i%2==0?evenSumUpto+nums[i]:evenSumUpto;
             oddSumUpto=i%2==1?oddSumUpto+nums[i]:oddSumUpto;
        }
        return ans;
        
    }
}