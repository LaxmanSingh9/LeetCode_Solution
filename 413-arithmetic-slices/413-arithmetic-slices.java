class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        int ans=0;
         for(int i=0;i<n-1;i+=1){
             int prev=arr[i],diff=arr[i+1]-arr[i];prev=arr[i];int j=i+1;
             while(j<n && arr[j]-prev==diff){
                prev=arr[j];
                j+=1;
             }
             if(j-i+1>=3){
                 ans+=j-i-2;
             }
               
         } 
        return ans;
    }

                   }
