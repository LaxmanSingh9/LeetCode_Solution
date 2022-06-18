class Solution {
    public boolean isValidParthesis(String string){
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<string.length();i+=1){
        if(!stack.empty() && string.charAt(i)!='(' &&string.charAt(i)!=stack.peek() ){
                stack.pop();
        }
        else{
                stack.push( string.charAt(i));
          }
       }
       
        return stack.empty();
        
        
    }
    public List<String> ans=new ArrayList<>();
     public void solve(int n,int type1,int type2,String s){
        if(s.length()==2*n){
            if(isValidParthesis(s) && !ans.contains(s)){
                ans.add(s);
            }
            return ;
        }
        int ans=0;
        if(type1>0){
            solve(n,type1-1,type2,s+"(");
        }
        if(type2>0){
            solve(n,type1,type2-1,s+")");
        }
       
    }
    public List<String> generateParenthesis(int n) {
         solve(n,n,n,"");
         return ans;
    }
}