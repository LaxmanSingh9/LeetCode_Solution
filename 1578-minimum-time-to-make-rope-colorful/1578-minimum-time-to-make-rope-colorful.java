class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0,n=neededTime.length,prev=0;
        for(int i=1;i<n;i+=1){
            if(colors.charAt(i)==colors.charAt(i-1)){
                ans+=Math.min(prev==0?neededTime[i-1]:prev,neededTime[i]);
                prev=Math.max(neededTime[i],prev==0?neededTime[i-1]:prev);
            }
            else{
                prev=0;
            }
        }
        return ans;
    }
}