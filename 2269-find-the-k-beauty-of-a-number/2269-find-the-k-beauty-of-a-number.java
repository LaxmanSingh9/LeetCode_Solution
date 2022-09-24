class Solution {
    public int isDivisorOfNum(int num,int d){
        return d==0 || num%d!=0?0:1;
    }
    public int divisorSubstrings(int num, int k) {
       int ans=0;String s=String.valueOf(num);
       StringBuilder bd=new StringBuilder();
       for(int i=0;i<s.length();i++) {
          bd.append(s.charAt(i));
          if(bd.length()==k){
              ans+=isDivisorOfNum(num,Integer.parseInt(bd.toString()));
              bd.deleteCharAt(0);
          } 
       }
       return ans; 
        
    }
}