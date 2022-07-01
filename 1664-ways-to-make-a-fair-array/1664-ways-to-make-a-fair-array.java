class Solution {
    public int waysToMakeFair(int[] nums) {
        int ans=0,n=nums.length;
        if(n==1 || n==2){
            return n==1?1:0;
        }
        int []oddSum=new int[n];int []evenSum=new int[n];
        for(int i=0;i<n;i+=1){
            if(i%2==0){
                evenSum[i]=i==0?nums[i]:evenSum[i-1]+nums[i];
                oddSum[i]=i==0?0:oddSum[i-1];
            }
            else{
                oddSum[i]=oddSum[i-1]+nums[i];
                evenSum[i]=i==0?0:evenSum[i-1];
            }
              
        }
        // System.out.println(Arrays.toString(evenSum));
        //     System.out.println(Arrays.toString(oddSum));
        for(int i=0;i<n;i+=1){
           if(i!=0 && evenSum[i-1]+oddSum[n-1]-oddSum[i]==oddSum[i-1]+evenSum[n-1]-evenSum[i]){
               ans+=1;
           }
           else if(i==0 && evenSum[n-1]-nums[i]==oddSum[n-1]){
               ans+=1;
           }
               
        }
        return ans;
        
    }
}