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
           if(to>=arr.length){
               break;
           }
           currMax=Math.max(currMax,arr[to]);
           int leftMaxx=currMax*(j+1);
           int rightMaxx=solve(arr,k,to+1,memo);
           ans=Math.max(ans,leftMaxx+rightMaxx);
         }
       memo[index]=ans;
       return ans;
        
        
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int []memo=new int[arr.length];
        Arrays.fill(memo,-1);
        return  solve(arr,k,0,memo);
    }
}