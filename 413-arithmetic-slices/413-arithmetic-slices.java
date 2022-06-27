class Solution {
    public int solve(int n,int[]arr,int prev){
        if(n<3){
            return 0;
        }
        if(arr[n-1]+arr[n-3]==2*arr[n-2]){
            prev+=1;
            return prev+solve(n-1,arr,prev);
        }
        else{
            return solve(n-1,arr,0);
        }
        
    }
    public int numberOfArithmeticSlices(int[] arr) {
        int n=arr.length;
        return solve(n,arr,0);
    }

}
