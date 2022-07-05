class Solution {
    public int[] sumZero(int n) {
        int ans[]=new int[n];int count=1,sum=0;
        for(int i=0;i<n-1;i+=1){
            ans[i]=count;
            sum+=count;
            count+=1;
        }
        ans[n-1]=-sum;
        return ans;
    }
}