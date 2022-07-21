class Solution {
    public String shortestCommonSupersequence(String lcs,String s1, String s2) {
        int i = 0, j = 0;
        String res = "";
        for (char c : lcs.toCharArray()) {
            while(s1.charAt(i) != c){ res += s1.charAt(i);i+=1;}
            while (s2.charAt(j) != c){res += s2.charAt(j);j+=1;}
            res += c;i+=1;j+=1;
        }
        return res + s1.substring(i) + s2.substring(j);
    }
    public String LCS(String s1,String s2,int i,int j,String[][]memo){
        if(i==s1.length() || j==s2.length() ){
            return "";
        }
        if(memo[i][j]!="A"){
            return memo[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            memo[i][j]=s1.charAt(i)+LCS(s1,s2,i+1,j+1,memo);
        }
        else{
            String smallAns1=LCS(s1,s2,i+1,j,memo);
            String smallAns2=LCS(s1,s2,i,j+1,memo);
            memo[i][j]=smallAns1.length()>smallAns2.length()?smallAns1:smallAns2;
        }
        return memo[i][j];

        
    }
    public String shortestCommonSupersequence(String str1, String str2) {
         String [][]memo=new String[str1.length()][str2.length()];
         for(String []ar:memo)
             Arrays.fill(ar,"A");
         String lcs=LCS(str1,str2,0,0,memo);
         return shortestCommonSupersequence(lcs,str1,str2);
         
        
    }
}