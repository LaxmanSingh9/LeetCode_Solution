class Solution {
    public int numOfSubarrays(int[] arr, int k, int thres){
       System.out.println(arr.length); 
       int res=0,sum=0,i=0;
       for(int j=0;j<k;j++)sum+=arr[j];
       if(sum/k>=thres)res++; 
       for(int j=k;j<arr.length;j++){
           sum+=arr[j]-arr[j-k]; 
           if(sum/k>=thres)res++;
       }
       return res; 
   }
}