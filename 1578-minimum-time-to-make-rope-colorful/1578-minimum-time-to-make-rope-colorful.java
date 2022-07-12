class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans=0,n=neededTime.length;
        for(int i=1;i<n;i+=1){
            if(colors.charAt(i)==colors.charAt(i-1)){
                ans+=Math.min(neededTime[i-1],neededTime[i]);
                neededTime[i]=Math.max(neededTime[i],neededTime[i-1]);
            }
        }
        return ans;
    }
}