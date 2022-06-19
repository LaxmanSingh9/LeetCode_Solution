class Solution {
    public int solve(int f,int eggs,int[][]memo){
        if(f<=1 || eggs==1){
            return f;
        }
        if(memo[f][eggs]!=-1){
           return memo[f][eggs];
        }
        int min=Integer.MAX_VALUE;   
        for(int i=1;i<=f;i+=1){
            int breakEgg=solve(i-1,eggs-1,memo);
            int notBreakEgg=solve(f-i,eggs,memo);
            int smallAns=1+Math.max(breakEgg,notBreakEgg);
            min=Math.min(min,smallAns);
        }
        memo[f][eggs]=min;
        return min;
        
    }
    public int twoEggDrop(int n) {
        int[][]memo=new int[n+1][3];
        for(int[] ar:memo){
            Arrays.fill(ar,-1);
        }
        return solve(n,2,memo);
        
    }
}