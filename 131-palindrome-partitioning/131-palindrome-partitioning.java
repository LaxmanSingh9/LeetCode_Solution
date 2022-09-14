class Solution {
    public boolean isPalm(String s,int l,int r){
       while(l<r){
           if(s.charAt(l++)!=s.charAt(r--))return false;
       }
       return true;
    }
    public List<List<String>>ans=new ArrayList<>();
    public void solve(String s,int st,int e,List<String>list){
        //base case
        if(e-st==0){
            ans.add(new ArrayList<>(list));
        }
        for(int i=st;i<e;i++){
            if(isPalm(s,st,i)) {
                list.add(s.substring(st,i+1));
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