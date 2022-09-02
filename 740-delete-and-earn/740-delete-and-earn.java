class Solution {
    public int deleteAndEarn(int[] nums) {
        int []freq=new int[10003];
        List<Integer>arr=new ArrayList<>();
        arr.add(0);
        for(int val:nums){
             if(freq[val]==0)
                arr.add(val); 
             freq[val]+=1;
        }
        Collections.sort(arr);
        int []dp=new int[arr.size()];
        dp[1]=freq[arr.get(1)]*arr.get(1);
        for(int i=2;i<arr.size();i+=1){
            int curVal=freq[arr.get(i)]*arr.get(i);
            if(arr.get(i)-arr.get(i-1)!=1){
                dp[i]=dp[i-1]+curVal;
            }
            else{
                dp[i]=Math.max(dp[i-1],curVal+dp[i-2]);
            }
        }
        return dp[dp.length-1];
    }
}