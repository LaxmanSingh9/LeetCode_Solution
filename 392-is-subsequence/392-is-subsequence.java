class Solution {
 
    public boolean solve(String s,String t,int i,int j){
       if(i==-1 || j==-1){
           return i==-1?true:false;
       }
       if(s.charAt(i)==t.charAt(j)){
            return solve(s,t,i-1,j-1);
        
        }
        return solve(s,t,i,j-1);
        
    }
    
    public boolean isSubsequence(String s, String t) {
        int n=s.length();int m=t.length();
        return solve(s,t,n-1,m-1);
        
    }
    
    
}