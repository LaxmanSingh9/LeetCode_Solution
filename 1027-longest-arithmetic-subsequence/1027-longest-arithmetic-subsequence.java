class Solution {
    private Integer limit=20001,maxNum=10000;
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length,las=1;
        int[][]dp=new int[nums.length][limit];
        for(int i=0;i<nums.length;i++){
           for(int j=i-1;j>=0;j--){
              int diff=(nums[j]-nums[i])+maxNum;
              dp[i][diff]=Math.max(dp[i][diff],1+dp[j][diff]); 
              las=Math.max(las,dp[i][diff]);  
           } 
        }
        return las+1;
        
    }
}