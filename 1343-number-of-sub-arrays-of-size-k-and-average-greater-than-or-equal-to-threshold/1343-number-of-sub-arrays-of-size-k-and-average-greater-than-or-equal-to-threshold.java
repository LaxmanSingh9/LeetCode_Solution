class Solution {
    public int numOfSubarrays(int[] arr, int k, int thres){
       int res=0,sum=0,i=0;
       for(int j=0;j<arr.length;j++){
           sum+=arr[j];
           if(j-i+1==k){
              if(sum/k>=thres)res+=1;
              sum-=arr[i];i++; 
           }
       }
       return res; 
        
    }
}