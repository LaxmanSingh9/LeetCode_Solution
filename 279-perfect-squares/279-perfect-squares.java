class Solution {
    public int[] perSqUpToN(int n){
       int []ar=new int[n];
       ar[0]=1;
       for(int i=2;i<=n;i++)
          ar[i-1]=i*i; 
       return ar;
    }
    public int totalPerSqUpToN(int target,int idx,int []ar,int [][]memo){
        if(target==0) 
           return 0;
        if(target<0 || idx<0)
            return Integer.MAX_VALUE;
        if(memo[idx][target]!=-1)
            return memo[idx][target];
        int ans1=Integer.MAX_VALUE,ans2=Integer.MAX_VALUE;
        if(ar[idx]<=target)
          ans1=1+totalPerSqUpToN(target-ar[idx],idx,ar,memo);
        ans2=totalPerSqUpToN(target,idx-1,ar,memo);
        
        return memo[idx][target]=Math.min(ans1,ans2);
        
    }
    public int numSquares(int n) {
        int []ar=perSqUpToN(100);
        int[][]memo=new int[ar.length][n+1];
        for(int []a:memo)
            Arrays.fill(a,-1);
        return totalPerSqUpToN(n,ar.length-1,ar,memo);
    }
}