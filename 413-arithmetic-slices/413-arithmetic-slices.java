class Solution {
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        int dp[]=new int[n];
         for(int i=1;i<n-1;i+=1){
             if(arr[i]-arr[i-1]==arr[i+1]-arr[i]){
                 dp[i]+=(dp[i-1]+1);
             }
        }
        return Arrays.stream(dp).sum();
    }

}
