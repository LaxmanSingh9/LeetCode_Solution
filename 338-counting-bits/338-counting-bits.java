class Solution {
    public int TotalonesInGivenrNumber(int n){
        int ones=0;
        int bit=0;
        while(n!=0){
           bit=n%2;
           if(bit==1){
              ones+=1; 
           }
           n=n/2;
        }
        return ones;
        
    }
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        for(int i=0;i<=n;i+=1){
            ans[i]=TotalonesInGivenrNumber(i);
        }
        return ans;
    }
}