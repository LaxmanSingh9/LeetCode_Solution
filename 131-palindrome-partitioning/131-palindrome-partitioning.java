class Solution {
    List<List<String>>ans=new ArrayList<>();
    public String isPalm(String s,int l ,int r){
        int l1=l,r1=r;
        while(l<r && s.charAt(l)==s.charAt(r)){
            l+=1;
            r-=1;
       }
       return l>=r?s.substring(l1,r1+1):"";
    }
    public void solve(String s ,int st ,int e ,List<String>list,boolean [][]memo){
        if(e-st==0 ){
            ans.add(new ArrayList<>(list));
            return ;
        }
        for(int i=st;i<e;i+=1){
           String str=isPalm(s,st,i);
           if(str.length()>0){
                list.add(str);
                solve(s,i+1,e,list,memo);
                list.remove(list.size()-1);
            }
        }
        return;
       
    }
    public List<List<String>> partition(String s) {
        int n=s.length();boolean[][]memo=new boolean[n+1][n+1];
        solve(s ,0,n,new ArrayList<>(),memo);
        return ans;
    }
}