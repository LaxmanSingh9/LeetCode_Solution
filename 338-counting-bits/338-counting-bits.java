class Solution {
    public int solve(int n,int []ans){
        if(n==0)
          return 0;
        if(n==1)
          return 1;
        if(ans[n]!=-1){
            return ans[n];
        }
        int val=0;
        val=solve(n/2,ans);
        if(n%2==1){
            val+=1;
        }
        ans[n]=val;
        return val;
        
    }
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        Arrays.fill(ans,-1);
        for(int i=0;i<=n;i+=1){
            ans[i]=solve(i,ans);
        }
        return ans;
    }
}