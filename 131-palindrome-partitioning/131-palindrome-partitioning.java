class Solution {
    public boolean isPalm(String s1){
        String r = new StringBuffer(s1).reverse().toString();
       // System.out.println(s1+" "+r);
        if(r.length()>0 && r.equals(s1)){
            return true;
        }
        
        return false;
    }
    List<List<String>>ans=new ArrayList<>();
    public void solve(String s ,int st ,int e ,List<String>list){
        if(e-st==0){
            ans.add(new ArrayList<>(list));
            return ;
        }
        List<String>list1=new ArrayList<>();
        for(int i=st;i<e;i+=1){
           if(isPalm(s.substring(st,i+1))) {
                list.add(s.substring(st,i+1));
                solve(s,i+1,e,list);
                list.remove(list.size()-1);
            }
        }
       return;
       
    }
    public List<List<String>> partition(String s) {
        int n=s.length();
        solve(s ,0,n,new ArrayList<>());
        return ans;
    }
}