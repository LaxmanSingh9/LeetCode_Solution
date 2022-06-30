class Solution {
    public void permute(boolean []freq,List<List<Integer>>ans,List<Integer>permArr,int len){
        if(permArr.size()==freq.length){
            ans.add(permArr);
            return ;
        }
        for(int i=1;i<=freq.length;i+=1){
           if(!freq[i-1] && (i%len==0|| len%i==0)){
              permArr.add(i);
              freq[i-1]=true;len+=1;
              permute(freq,ans,permArr,len);
              permArr.remove(permArr.size()-1);
              freq[i-1]=false;
              len-=1;
                
          }
      }
        
        
        
    }
    public int countArrangement(int n) {
       boolean freq[]=new boolean[n];
       List<List<Integer>>ans=new ArrayList<>();
       permute(freq,ans,new ArrayList<>(),1);
       return ans.size();
    }
}