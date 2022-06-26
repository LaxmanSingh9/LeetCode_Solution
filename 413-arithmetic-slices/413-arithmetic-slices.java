class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        int ans=0;
         for(int i=0;i<n;i+=1){
             int prev=arr[i],j=i+1,diff=Integer.MIN_VALUE;
             while(j<n && (diff==Integer.MIN_VALUE ||((arr[j]-prev)==diff))){
                if(diff==Integer.MIN_VALUE){
                    diff=arr[j]-arr[i];
                }
                prev=arr[j];
                j+=1;
             }
             j-=1;
             if(j-i+1>=3){
                 ans+=j-i-1;
             }
               
         } 
        return ans;
    }

                   }
