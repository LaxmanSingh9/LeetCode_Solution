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
    public Map<String,Integer>map=new HashMap<>();
     public void solve(int n,int open,int close,String s){
        if(open==n&&close==n){
            if(isValidParthesis(s) && !map.containsKey(s)){
                ans.add(s);map.put(s,1);
            }
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