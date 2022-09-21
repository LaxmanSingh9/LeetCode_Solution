class Solution {
    private Integer limit=20001,maxNum=10000;
//     public int solve(int []arr,int idx,int diff){
//        if(idx>=arr.length)
//           return 0;
//        int incl=0,excl=0; 
//        if(arr[prev]-arr[idx]==diff ){
//           incl=1+Math.max(solve(arr,idx+1,diff); 
//        } 
//        else{
//            excl=Math.max(solve(arr,idx+1,arr[idx]),
//                         solve(arr,idx+1,prev)) 
//        } 
        
        
//     }
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length,las=1;
        int[][]dp=new int[nums.length][limit];
        for(int i=0;i<n;i++)
           dp[i][0]=1; 
        for(int i=1;i<nums.length;i++){
           for(int j=i-1;j>=0;j--){
              int diff=(nums[j]-nums[i])+maxNum;
              dp[i][diff]=Math.max(dp[i][diff],1+dp[j][diff]); 
           } 
        }
        for(int i=0;i<n;i++){
           for(int j=0;j<limit;j++){
                las=Math.max(las,dp[i][j]);        
           } 
        }  
        return las+1;
        
    }
}