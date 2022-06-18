class Solution {
   
    public List<String> ans=new ArrayList<>();
    public void solve(int n,int open,int close,String s){
        if(open==n&&close==n){
             ans.add(s);
              return ;
        }
        
        if(open<n){
            solve(n,open+1,close,s+"(");
        }
        if(close<open){
            solve(n,open,close+1,s+")");
        }
       
    }
    public List<String> generateParenthesis(int n) {
         solve(n,0,0,"");
         return ans;
    }
}