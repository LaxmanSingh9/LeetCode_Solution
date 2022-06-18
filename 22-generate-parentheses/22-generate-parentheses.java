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
     public void solve(int n,int type1,int type2,String s){
        if(type1==0&&type2==0){
            if(isValidParthesis(s) && !map.containsKey(s)){
                ans.add(s);map.put(s,1);
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