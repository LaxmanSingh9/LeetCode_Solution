class Solution {
    int ans=0;
    public void permute(boolean []freq,int len){
        if(len>freq.length){
            ans+=1;
            return;
        }
        for(int i=1;i<=freq.length;i+=1){
           if(!freq[i-1] && (i%len==0|| len%i==0)){
              freq[i-1]=true;len+=1;
              permute(freq,len);
              freq[i-1]=false;
              len-=1;
                
          }
      }
        
        
        
    }
    public int countArrangement(int n) {
       boolean freq[]=new boolean[n];
       permute(freq,1);
       return ans;
    }
}