class Solution {
     public int asciiOfAnString(String s){
        int asciiSum=0;
        for(int i=0;i<s.length();i+=1)
             asciiSum+=(int)s.charAt(i);
        return asciiSum;
    }
    int totalAsciiSum;
   public int allCommonSub(String s1,String s2,int i,int j,int[][]memo){
       if(i==s1.length() || j==s2.length()){
            if(i==s1.length() && j==s2.length()){return 0;}
            else{
                 String s=i==s1.length()?s2.substring(j,s2.length()):s1.substring(i,s1.length());
               return asciiOfAnString(s);
            }
           
       }   
       if(memo[i][j]!=-1){
           return memo[i][j];
       }
       int val=0;
       if(s1.charAt(i)==s2.charAt(j)){
          val=allCommonSub(s1,s2,i+1,j+1,memo);
           
       } 
      else{
          val=Math.min(allCommonSub(s1,s2,i+1,j,memo)+(int)s1.charAt(i),allCommonSub(s1,s2,i,j+1,memo)+(int)s2.charAt(j));
      }
     memo[i][j]=val;
     return memo[i][j];
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        int[][]memo=new int[s1.length()][s2.length()];
        for(int[]ar:memo){Arrays.fill(ar,-1);}
        return allCommonSub(s1,s2,0,0,memo);
    } 
}