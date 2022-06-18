class Solution {
    public int solve(int []arr,int k,int index,int[] memo){
        if(index>=arr.length){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int ans=0;
        int currMax=0;
        for(int j=0;j<k;j+=1){
           int to=j+index;
           
         }
       memo[index]=ans;
       return ans;
        
        
    }
    public int get(int[]dp,int index){
        if(index<=-1){
            return 0;
        }
        return dp[index];
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int []memo=new int[n];
        int ans=0,from=0,curMax=0;
        Arrays.fill(memo,0);
        for(int i=0;i<n;i+=1){
           curMax=0;
           for(int j=0;j<k;j+=1){
              from=i-j;
              if(from<0){
                  continue;
              }
              curMax=Math.max(arr[from],curMax);
              ans=curMax*(j+1)+get(memo,from-1);
              memo[i]=Math.max(ans,memo[i]);
         } 
        
        }
        
        return memo[n-1];
    }
}