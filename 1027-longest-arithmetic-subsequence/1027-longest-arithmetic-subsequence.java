class Solution {
    private Integer limit=2001,maxNum=510;
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length,las=2;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i=0;i<nums.length;i++){
           dp[i]=new HashMap<>(); 
           for(int j=0;j<i;j++){
              int diff=nums[j]-nums[i];
              dp[i].put(diff,dp[j].getOrDefault(diff,1)+1); 
              las=Math.max(las,dp[i].get(diff));  
           } 
        }
        return las;
        
    }
}