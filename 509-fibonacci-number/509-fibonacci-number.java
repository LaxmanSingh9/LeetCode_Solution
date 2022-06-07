class Solution {
    public int fib(int n) {
        if(n==0)
          return 0;
        int ans[]=new int[n+1];
        ans[0]=0;ans[1]=1;
        for(int i=2;i<=n;i+=1){
            ans[i]=ans[i-2]+ans[i-1];
        }
        return ans[n];
       
    }
}