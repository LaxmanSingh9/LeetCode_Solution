class Solution {
    public String isPalm(String s,int l,int r){
       int i=l,j=r-1; 
       while(i<=j){
           if(s.charAt(i)!=s.charAt(j)){
               return "";
           }
           i+=1;j-=1;
       }
       return s.substring(l,r); 
    }
    public List<List<String>>ans=new ArrayList<>();
    public void solve(String s,int st,int e,List<String>list){
        //base case
        if(e-st==0){
            ans.add(new ArrayList<>(list));
        }
        for(int i=st;i<e;i++){
            String pal=isPalm(s,st,i+1);
           //System.out.println(pal);
            if(pal.length()>0){
                list.add(pal);
                solve(s,i+1,e,list);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        solve(s,0,s.length(),new ArrayList<>());
        return ans;
    }
}