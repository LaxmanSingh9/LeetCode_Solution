class Solution {
    public int getLIS(int[]arr,int idx,int prev,int[][]memo){
        if(idx>=arr.length)
            return 0;
        if(prev!=-1 && memo[idx][prev]!=-1)
            return memo[idx][prev];
        int ans1=0,ans2=0;
        if(prev==-1 || arr[idx]>arr[prev])
            ans1=1+getLIS(arr,idx+1,idx,memo);
        ans2=getLIS(arr,idx+1,prev,memo);
        if(prev!=-1)
         memo[idx][prev]= Math.max(ans1,ans2);
        return Math.max(ans1,ans2);
    }
    
    public int lengthOfLIS(int[] nums) {
       int[][]memo=new int[2515][2515];
       for(int []ar:memo)
           Arrays.fill(ar,-1);
       return getLIS(nums,0,-1,memo);   
    }
}