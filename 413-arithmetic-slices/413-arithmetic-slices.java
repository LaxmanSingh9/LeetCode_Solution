class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
        int prev=0,ans=0;
         for(int i=1;i<n-1;i+=1){
             if(arr[i]-arr[i-1]==arr[i+1]-arr[i]){
                 ans+=(prev+1);
                 prev+=1;;
              }
              else{
                  prev=0;
              }
             
        }
        return ans;
    }

}
