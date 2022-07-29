class Solution {
    int ans=Integer.MAX_VALUE;
    public void solve(int []cookies,int idx,int []subset,int k){
        if(idx==cookies.length){
            int ans1=Integer.MIN_VALUE;
            for(int val:subset)
                ans1=Math.max(ans1,val);
            ans=Math.min(ans,ans1);
            return ;
        }
        for(int i=0;i<k;i+=1){
            subset[i]+=cookies[idx];
            solve(cookies,idx+1,subset,k);
            subset[i]-=cookies[idx];
        }
        
    }
    public int distributeCookies(int[] cookies, int k) {
         int []subset=new int[k];
         solve(cookies,0,subset,k);
         return ans;
    }
}