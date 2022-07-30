class Solution {
    int ans=Integer.MAX_VALUE;
    public void solve(int []jobs ,int k,int end,int []assignments,int max){
        if(end<=-1){
            ans=Math.min(max,ans);
            return;
        }
        if(max>=ans)return;
        for(int i=0;i<k;i+=1){
           if(i>0 && assignments[i]==assignments[i-1])continue;
           assignments[i]+=jobs[end];
           solve(jobs,k,end-1,assignments,Math.max(max,assignments[i]));
           assignments[i]-=jobs[end];
          
         }
               
   }
    public int minimumTimeRequired(int[] jobs, int k) {
        int []assignments=new int[k];
        Arrays.sort(jobs);
        solve(jobs,k,jobs.length-1,assignments,0);
        return ans;
    
        
    }
}