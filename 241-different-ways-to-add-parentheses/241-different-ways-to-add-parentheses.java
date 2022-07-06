class Solution {
    public int evalExpress(char c,int x,int y){
        if(c=='*')
            return x*y;
        if(c=='+')
          return x+y;
        return x-y;
    }
    public List<Integer>solve(String s ,Map<String,List<Integer>>map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        if(s.length()==1){
            List<Integer>ar=new ArrayList<>();
            ar.add(Integer.valueOf(s));
            return ar;
        }
        List<Integer>res=new ArrayList<>();
        for(int i=0;i<s.length();i+=1){
            char ch=s.charAt(i);
            if(ch=='*' || ch=='-' || ch=='+'){
                List<Integer>left=solve(s.substring(0,i),map);
                List<Integer>right=solve(s.substring(i+1),map);
                for(int x:left){
                    for(int y:right)
                        res.add(evalExpress(ch,x,y));      
                 }
            }
            
        }
        if(res.size()==0){
            res.add(Integer.valueOf(s));
        }
        map.put(s,res);
        return res;
        
        
    }
    public List<Integer> diffWaysToCompute(String expression) {
          Map<String,List<Integer>>map=new HashMap<>();
          return solve(expression,map);
    }
}