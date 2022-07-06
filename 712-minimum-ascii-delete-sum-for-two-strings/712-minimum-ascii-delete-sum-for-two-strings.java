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
          return 0;
       }   
       if(memo[i][j]!=-1){
           return memo[i][j];
       }
       int val=0;
       if(s1.charAt(i)==s2.charAt(j)){
           val=allCommonSub(s1,s2,i+1,j+1,memo)+(int)s1.charAt(i);
       } 
       else{ 
           val=Math.max(allCommonSub(s1,s2,i+1,j,memo),allCommonSub(s1,s2,i,j+1,memo));
       }
       memo[i][j]=val;
       return memo[i][j];
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        int ans[]=new int[1];ans[0]=0;
        totalAsciiSum=asciiOfAnString(s1)+asciiOfAnString(s2);
        int[][]memo=new int[s1.length()][s2.length()];
        for(int[]ar:memo){Arrays.fill(ar,-1);}
        return  totalAsciiSum-2*allCommonSub(s1,s2,0,0,memo);
    } 
}